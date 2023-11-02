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
    @NotNull(message = "El id no puede ser nulo")
    @NotBlank(message = "El id no puede ser vacío")
    private  int id;
    @NotNull(message = "El username no puede ser nulo")
    @NotBlank(message = "El el username no puede ser vacío")
    private String username;
    @NotNull(message = "El email no puede ser nulo")
    @NotBlank(message = "El email no puede ser vacío")
    private String email;
    @NotNull(message = "La contraseña no puede ser nulo")
    @NotBlank(message = "La contraseña no puede ser vacío")
    private String password;
    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El nombre no puede ser vacío")
    private String firstName;
    @NotNull(message = "El apellido no puede ser nulo")
    @NotBlank(message = "El apellido no puede ser vacío")
    private String lastName;
    @NotNull(message = "El telefono no puede ser nulo")
    @NotBlank(message = "El telefono no puede ser vacío")
    private String phone;
    @NotNull(message = "La dirección no puede ser nulo")
    @NotBlank(message = "La dirección no puede ser vacío")
    private String address;
    @NotNull(message = "El rol no puede ser nulo")
    @NotBlank(message = "El rol no puede ser vacío")
    private int idRol;

}
