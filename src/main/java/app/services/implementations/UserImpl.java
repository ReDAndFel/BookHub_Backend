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

        if(flagEmail != null){
            throw new Exception("Ya existe un usuario con el correo " + userDTO.getEmail());
        }

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        Rol rol = rolInterface.getRol(1);
        user.setRol(rol);

        userRepo.save(user);
        emailInterface.sendEmail(new EmailDTO("Se registró con exito", "Bienvenido " + user.getUsername() + ", se ha registrado con exito", user.getEmail()));

        return user.getId();
    }

    @Override
    public int updateUser(int idUser, UserDTO userDTO) throws Exception {
        return 0;
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
    public int changeOldPassword(int idUser, PasswordDTO passwordDTO) throws Exception {
        return 0;
    }

    @Override
    public void recuperatePassword(String emailUser) throws Exception {

    }

    @Override
    public int changePasswordRecuperated(String emailUser, PasswordDTO passwordDTO) throws Exception {
        return 0;
    }

    @Override
    public List<UserDTO> listUserFriends(int idUser) throws Exception {
        return null;
    }

    @Override
    public void addFriend(int idUser, int idUserFriend) throws Exception {

    }

    @Override
    public void removeFriend(int idUser, int idUserFriend) throws Exception {

    }

    @Override
    public void validateExist(User foundUser, int idUser) throws Exception {
        if (foundUser == null) {
            throw new Exception("No se encontro un usuario con el id " + idUser);
        }
    }
}
