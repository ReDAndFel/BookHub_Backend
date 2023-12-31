package app.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SesionDTO {
    @NotNull(message = "El email no puede ser nulo")
    @NotBlank(message = "El email no puede ser vacío")
    private String email;
    @NotNull(message = "La contraseña no puede ser nulo")
    @NotBlank(message = "La contraseña no puede ser vacío")
    private String password;

}
