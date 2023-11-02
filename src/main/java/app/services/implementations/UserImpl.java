package app.services.implementations;

import app.dtos.EmailDTO;
import app.dtos.PasswordDTO;
import app.dtos.UserDTO;
import app.model.Rol;
import app.model.User;
import app.repositories.UserRepo;
import app.services.interfaces.EmailInterface;
import app.services.interfaces.RolInterface;
import app.services.interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserImpl implements UserInterface {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RolInterface rolInterface;
    @Autowired
    private EmailInterface emailInterface;

    @Override
    public int registerUser(UserDTO userDTO) throws Exception {
        User flagEmail = userRepo.findUserByEmail(userDTO.getEmail());
        if (flagEmail != null) {
            throw new Exception("Ya existe un usuario con el correo " + userDTO.getEmail());
        }
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        String password = userDTO.getPassword();
        String confirmPassword = userDTO.getConfirmPassword();
        validatePassword(password, confirmPassword);
        user.setPassword(password);
        Rol rol = rolInterface.getRol(1);
        user.setRol(rol);
        userRepo.save(user);
        emailInterface.sendEmail(new EmailDTO("Se registró con exito", "Bienvenido " + user.getUsername() + ", se ha registrado con exito", user.getEmail()));
        return user.getId();
    }

    @Override
    public int updateUser(int idUser, UserDTO userDTO) throws Exception {
        User foundUser = getUser(idUser);
        validateExist(foundUser, idUser);
        foundUser.setAddress(userDTO.getAddress());
        foundUser.setPhone(userDTO.getPhone());
        foundUser.setFirstName(userDTO.getFirstName());
        foundUser.setLastName(userDTO.getLastName());
        userRepo.save(foundUser);
        emailInterface.sendEmail(new EmailDTO("Se actualizó con exito", "Ha actualizado con exito la informacion de su cuenta", foundUser.getEmail()));
        return foundUser.getId();
    }

    @Override
    public UserDTO getUserDTO(int idUser) throws Exception {
        User user = userRepo.findById(idUser).get();
        UserDTO userDTO = convertToDTO(user);
        return userDTO;
    }

    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                "",
                user.getFirstName(),
                user.getLastName(),
                user.getPhone(),
                user.getAddress(),
                user.getRol().getId()
        );
        return userDTO;
    }

    @Override
    public User getUser(int idUser) throws Exception {
        User user = userRepo.findById(idUser).get();
        return user;
    }

    @Override
    public List<UserDTO> listAllUsers() throws Exception {
        List<User> userList = userRepo.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user: userList){
            userDTOList.add(convertToDTO(user));
        }
        return userDTOList;
    }

    @Override
    public int changeOldPassword(int idUser, PasswordDTO passwordDTO) throws Exception {
        User foundUser = getUser(idUser);
        validateExist(foundUser, idUser);
        String password = passwordDTO.getPassword();
        String confirmPassword = passwordDTO.getConfirmPassword();
        validatePassword(password, confirmPassword);
        foundUser.setPassword(password);
        userRepo.save(foundUser);
        emailInterface.sendEmail(new EmailDTO("Se actualizó su contraseña", "Ha actualizado con exito la contraseña de su cuenta", foundUser.getEmail()));
        return foundUser.getId();
    }

    @Override
    public void recuperatePassword(String emailUser) throws Exception {
        emailInterface.sendEmail(new EmailDTO("Recuperar contraseña","Para recuperar su contraseña ingrese al siguiente enlace: https://localhost:4200/restaurar_contraseña/" + emailUser,emailUser));
    }

    @Override
    public int changePasswordRecuperated(String emailUser, PasswordDTO passwordDTO) throws Exception {
        User foundUser  = userRepo.findUserByEmail(emailUser);
        validateExist(foundUser, 0);
        String password = passwordDTO.getPassword();
        String confirmPassword = passwordDTO.getConfirmPassword();
        validatePassword(password, confirmPassword);
        foundUser.setPassword(password);
        userRepo.save(foundUser);
        emailInterface.sendEmail(new EmailDTO("Se recuperó su contraseña", "Ha recuperado con exito la contraseña de su cuenta", foundUser.getEmail()));
        return foundUser.getId();
    }

    @Override
    public List<UserDTO> listUserFriends(int idUser) throws Exception {
        List<User> userList = userRepo.listUserFriends(idUser);
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user: userList){
            userDTOList.add(convertToDTO(user));
        }
        return userDTOList;
    }

    @Override
    public void addFriend(int idUser, int idUserFriend) throws Exception {
        User user = getUser(idUser);
        validateExist(user,idUser);
        User userFriend = getUser(idUserFriend);
        validateExist(userFriend,idUserFriend);
        user.getFriend().add(userFriend);
        userRepo.save(user);
    }

    @Override
    public void removeFriend(int idUser, int idUserFriend) throws Exception {
        User user = getUser(idUser);
        validateExist(user,idUser);
        User userFriend = getUser(idUserFriend);
        validateExist(userFriend,idUserFriend);
        List<User> listFriends = user.getFriend();
        int cont = 0;
        for (User userAux: listFriends){
            if(userAux.getId() == userFriend.getId()){
                listFriends.remove(cont);
                break;
            }
            cont++;
        }
        userRepo.save(user);
    }

    @Override
    public void validateExist(User foundUser, int idUser) throws Exception {
        if (foundUser == null) {
            throw new Exception("No se encontro un usuario con el id " + idUser);
        }
    }

    @Override
    public boolean validatePassword(String password, String confirmPassword) throws Exception {
        if (password.equals(confirmPassword) != true) {
            throw new Exception("Las contraseñas no coinciden");
        }
        return true;
    }
}
