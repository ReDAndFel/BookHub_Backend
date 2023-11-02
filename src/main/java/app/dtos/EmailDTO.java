package app.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EmailDTO {
    @NotNull(message = "El asunto no puede ser nulo")
    @NotBlank(message = "El asunto no puede ser vacio")
    String subject;
    @NotNull(message = "El cuerpo no puede ser nulo")
    @NotBlank(message = "El cuerpo no puede ser vacio")
    String body;
    @NotNull(message = "El destinatario no puede ser nulo")
    @NotBlank(message = "El destinatario no puede ser vacio")
    String receiver;
}
