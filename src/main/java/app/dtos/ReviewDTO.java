package app.dtos;

import app.model.Book;
import app.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class ReviewDTO {
    @NotNull(message = "El id no puede ser nulo")
    @NotBlank(message = "El id no puede ser vacío")
    private  int id;
    @NotNull(message = "La puntuacion no puede ser nulo")
    @NotBlank(message = "La puntuacion no puede ser vacío")
    private int puntuation;
    @NotNull(message = "La review no puede ser nulo")
    @NotBlank(message = "La review no puede ser vacío")
    private String review;
    @NotNull(message = "La fecha no puede ser nulo")
    @NotBlank(message = "La fecha no puede ser vacío")
    private LocalDate date;
    @NotNull(message = "El id de libro no puede ser nulo")
    @NotBlank(message = "El id de libro no puede ser vacío")
    private int idBook;
    @NotNull(message = "El id de usuario no puede ser nulo")
    @NotBlank(message = "El id de usuario no puede ser vacío")
    private int idUser;


}
