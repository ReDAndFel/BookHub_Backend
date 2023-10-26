package app.services.interfaces;

import app.dtos.PasswordDTO;
import app.dtos.UserDTO;
import app.model.User;

import java.util.List;


public interface UserInterface {
    String registerUser(UserDTO userDTO) throws Exception;
    String updateUser(int idUser, UserDTO userDTO) throws Exception;
    UserDTO getUserDTO(int idUser) throws Exception;
    User getUser(int idUser) throws Exception;
    String changeOldPassword(int idUser, PasswordDTO passwordDTO ) throws Exception;
    void recuperatePassword(String emailUser) throws Exception;
    String changePasswordRecuperated(String emailUser, PasswordDTO passwordDTO) throws Exception;
    List<UserDTO> listUserFriends (int idUser) throws Exception;
    void addFriend(int idUser, int idUserFriend) throws Exception;
    void removeFriend(int idUser, int idUserFriend) throws Exception;
}
