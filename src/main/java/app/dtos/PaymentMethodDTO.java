package app.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class PaymentMethodDTO {

    int id;
    @NotNull(message = "El numero de tarjeta no puede ser nulo")
    @NotBlank(message = "El numero de tarjeta no puede ser vacío")
    String cardNumber;
    @NotNull(message = "El titular no puede ser nulo")
    @NotBlank(message = "El titular no puede ser vacío")
    String surname;
    @NotNull(message = "La fecha de expedicion no puede ser nulo")
    @NotBlank(message = "La fecha de expedicion no puede ser vacío")
    String expeditionDate;
    @NotNull(message = "El cvv no puede ser nulo")
    @NotBlank(message = "El cvv no puede ser vacío")
    int cvv;
    @NotNull(message = "El estado no puede ser nulo")
    @NotBlank(message = "El estado no puede ser vacío")
    boolean state;
    @NotNull(message = "El id de usuario no puede ser nulo")
    @NotBlank(message = "El id de usuario no puede ser vacío")
    private int idUser;

}
