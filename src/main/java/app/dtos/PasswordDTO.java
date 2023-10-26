package app.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PasswordDTO {

    @NotNull(message = "La contraseña no puede ser nulo")
    @NotBlank(message = "La contraseña no puede ser vacío")
    private String password;
    @NotNull(message = "La confirmacion de contraseña no puede ser nulo")
    @NotBlank(message = "La confirmacion de contraseña no puede ser vacío")
    private String confirmPassword;
}
