package app.controllers;

import app.dtos.MessageDTO;
import app.dtos.PasswordDTO;
import app.dtos.UserDTO;
import app.services.interfaces.UserInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/usuario")
public class UserController {
    private final UserInterface userInterface;
    @PutMapping("/actualizar/{idUser}")
    public ResponseEntity<MessageDTO> updatePerson(@PathVariable int idUser, @RequestBody UserDTO userDTO) throws Exception {
        userInterface.updateUser(idUser, userDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(HttpStatus.OK, false, "Usuario actualizado correctamente"));
    }
    @PutMapping("/restaurar_contraseña/{emailUser}")
    public ResponseEntity<MessageDTO> changePasswordRecuperated(@PathVariable String emailUser, @RequestBody PasswordDTO passwordDTO) throws Exception {
        userInterface.changePasswordRecuperated(emailUser, passwordDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(HttpStatus.OK, false, "Contraseña cambiada con exito"));
    }
    @PutMapping("/cambiar_contraseña/{idUser}")
    public ResponseEntity<MessageDTO> changeOldPassword(@PathVariable int idUser, @RequestBody PasswordDTO passwordDTO) throws Exception {
        userInterface.changeOldPassword(idUser, passwordDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(HttpStatus.OK, false, "Contraseña cambiada con exito"));
    }
    @PostMapping("/recuperar_contraseña")
    public ResponseEntity<MessageDTO> recuperatePassword(@RequestBody String email) throws Exception {
        userInterface.recuperatePassword(email);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(HttpStatus.OK, false, "Correo de recuperacion de contraseña enviado con exito"));
    }
    @GetMapping("/obtener_amigos/{idUser}")
    public ResponseEntity<MessageDTO> listFriendsUser(@PathVariable int idUser) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,userInterface.listUserFriends(idUser)));
    }
    @PostMapping("/agregar_amigo/{diUser}/{idUserFriend}")
    public ResponseEntity<MessageDTO> addFriend(@PathVariable int idUser, @PathVariable int idUserFriend) throws Exception {
        userInterface.addFriend(idUser, idUserFriend);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(HttpStatus.OK, false, "Usuario agregado correctamente a amigos"));
    }
    @DeleteMapping("/quitar_amigo/{idUser}/{idUserFriend}")
    public ResponseEntity<MessageDTO> removeFriend(@PathVariable int idUser, @PathVariable int idUserFriend) throws Exception{
        userInterface.removeFriend(idUser,idUserFriend);
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,"Usuario eliminado correctamente de amigos"));
    }
    @GetMapping("/obtener_usuario/{idUser}")
    public ResponseEntity<MessageDTO> getUser(@PathVariable int idUser) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,userInterface.getUserDTO(idUser)));
    }
    @GetMapping("/obtener_usuarios")
    public ResponseEntity<MessageDTO> getAllUsers() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,userInterface.listAllUsers()));
    }
}
