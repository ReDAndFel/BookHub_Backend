package app.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RolDTO {

    @NotNull(message = "El id no puede ser nulo")
    @NotBlank(message = "El id no puede ser vacío")
    private int id;
    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El nombre no puede ser vacío")
    private String nombre;
}
