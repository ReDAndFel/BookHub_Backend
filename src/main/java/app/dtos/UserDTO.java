package app.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

    private  int id;

    private String username;
    @NotNull(message = "El email no puede ser nulo")
    @NotBlank(message = "El email no puede ser vacío")
    private String email;
    @NotNull(message = "La contraseña no puede ser nulo")
    @NotBlank(message = "La contraseña no puede ser vacío")
    private String password;

    @NotNull(message = "La confirmacion de contraseña no puede ser nulo")
    @NotBlank(message = "La confirmacion de contraseña no puede ser vacío")
    private String confirmPassword;

    private String firstName;

    private String lastName;

    private String phone;

    private String address;

    private int idRol;

}
