package app.services.implementations;

import app.dtos.PasswordDTO;
import app.dtos.UserDTO;
import app.model.User;
import app.services.interfaces.UserInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl implements UserInterface {
    @Override
    public String registerUser(UserDTO userDTO) throws Exception {
        return null;
    }

    @Override
    public String updateUser(int idUser, UserDTO userDTO) throws Exception {
        return null;
    }

    @Override
    public UserDTO getUserDTO(int idUser) throws Exception {
        return null;
    }

    @Override
    public User getUser(int idUser) throws Exception {
        return null;
    }

    @Override
    public String changeOldPassword(int idUser, PasswordDTO passwordDTO) throws Exception {
        return null;
    }

    @Override
    public void recuperatePassword(String emailUser) throws Exception {

    }

    @Override
    public String changePasswordRecuperated(String emailUser, PasswordDTO passwordDTO) throws Exception {
        return null;
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
}
