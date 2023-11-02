package app.services.interfaces;

import app.dtos.PasswordDTO;
import app.dtos.UserDTO;
import app.model.User;

import java.util.List;


public interface UserInterface {
    int registerUser(UserDTO userDTO) throws Exception;
    int updateUser(int idUser, UserDTO userDTO) throws Exception;
    UserDTO getUserDTO(int idUser) throws Exception;
    User getUser(int idUser) throws Exception;
    int changeOldPassword(int idUser, PasswordDTO passwordDTO ) throws Exception;
    void recuperatePassword(String emailUser) throws Exception;
    int changePasswordRecuperated(String emailUser, PasswordDTO passwordDTO) throws Exception;
    List<UserDTO> listUserFriends (int idUser) throws Exception;
    void addFriend(int idUser, int idUserFriend) throws Exception;
    void removeFriend(int idUser, int idUserFriend) throws Exception;
    void validateExist(User foundUser, int idUser) throws Exception;
}
