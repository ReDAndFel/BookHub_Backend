package app.dtos;

import app.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class TransactionDTO {
    @NotNull(message = "El id no puede ser nulo")
    @NotBlank(message = "El id no puede ser vacío")
    private  int id;
    @NotNull(message = "El valor total no puede ser nulo")
    @NotBlank(message = "El valor total no puede ser vacío")
    private float totalPrice;
    @NotNull(message = "La fecha no puede ser nulo")
    @NotBlank(message = "La fecha no puede ser vacío")
    private LocalDate date;
    @NotNull(message = "El id de metodo de pago no puede ser nulo")
    @NotBlank(message = "El id de metodo de pago no puede ser vacío")
    private int idPaymentMethod;
    @NotNull(message = "La lista de detalles transaccion no puede ser nulo")
    @NotBlank(message = "El lista de detalles transaccion no puede ser vacío")
    private List<TransactionDetailDTO> transactionDetailGetDTOS;
    @NotNull(message = "El id de usuario no puede ser nulo")
    @NotBlank(message = "El id de usuario no puede ser vacío")
    private User user;

}
