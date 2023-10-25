package app.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ImageDTO {

    @NotNull(message = "El id no puede ser nulo")
    @NotBlank(message = "El id no puede ser vacío")
    private String id;
    @NotNull(message = "El url no puede ser nulo")
    @NotBlank(message = "El url no puede ser vacío")
    private String url;
}
