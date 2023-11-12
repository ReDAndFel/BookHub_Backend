package app.controllers;

import app.dtos.MessageDTO;
import app.dtos.SesionDTO;
import app.dtos.UserDTO;
import app.services.interfaces.SesionInterface;
import app.services.interfaces.UserInterface;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/autenticacion")
@CrossOrigin(origins = "*")
public class AuthController {
    private final UserInterface userInterface;
    private final SesionInterface sesionInterface;
    @PostMapping("/login")
    public ResponseEntity<MessageDTO> login(@Valid @RequestBody SesionDTO loginUser) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false, sesionInterface.login(loginUser)) );
    }
    @PostMapping("/registro")
    public ResponseEntity<MessageDTO> registerUser(@Valid @RequestBody UserDTO userDTO) throws Exception {
        userInterface.registerUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDTO(HttpStatus.CREATED,false, "Usuario registrado correctamente"));
    }
    /*@PostMapping("/refresh")
    public ResponseEntity<MessageDTO> refreshToken(@Valid @RequestBody TokenDTO tokenDTO) throws Exception {
        sesionInterface.refreshToken(tokenDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(HttpStatus.OK,false, "Token refrescado"));
    }*/
}
