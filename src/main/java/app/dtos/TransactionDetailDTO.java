package app.dtos;

import app.model.Book;
import app.model.Transaction;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TransactionDetailDTO {
    @NotNull(message = "El id no puede ser nulo")
    @NotBlank(message = "El id no puede ser vacío")
    int id;
    @NotNull(message = "El precio no puede ser nulo")
    @NotBlank(message = "El precio no puede ser vacío")
    private float price;

    @NotNull(message = "El id de transaccion no puede ser nulo")
    @NotBlank(message = "El id de transaccion no puede ser vacío")
    private int idTransaction;

    @NotNull(message = "El id de libro no puede ser nulo")
    @NotBlank(message = "El id de libro no puede ser vacío")
    private int idBook;
    

}
