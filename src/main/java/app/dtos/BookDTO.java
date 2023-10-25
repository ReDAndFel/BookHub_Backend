package app.dtos;

import app.model.Category;
import jakarta.persistence.ElementCollection;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
@AllArgsConstructor
@Getter
@Setter
public class BookDTO {
    @NotNull(message = "El id no puede ser nulo")
    @NotBlank(message = "El id no puede ser vacío")
    int id;
    @NotNull(message = "La imagen no puede ser nulo")
    @NotBlank(message = "La imagen no puede ser vacío")
    private ImageDTO image;
    @NotNull(message = "El titulo no puede ser nulo")
    @NotBlank(message = "El titulo no puede ser vacío")
    private String title;
    @NotNull(message = "El autor no puede ser nulo")
    @NotBlank(message = "El autor no puede ser vacío")
    private String autor;
    @NotNull(message = "La editorial no puede ser nulo")
    @NotBlank(message = "La editorial no puede ser vacío")
    private String editorial;
    @NotNull(message = "La fecha de lanzamiento no puede ser nulo")
    @NotBlank(message = "La fecha de lanzamiento no puede ser vacío")
    private LocalDate realeaseDate;
    @NotNull(message = "La puntuacion no puede ser nulo")
    @NotBlank(message = "La puntuacion no puede ser vacío")
    private float puntuation;
    @NotNull(message = "El precio no puede ser nulo")
    @NotBlank(message = "El precio no puede ser vacío")
    private float price;
    @NotNull(message = "La disponibilidad no puede ser nulo")
    @NotBlank(message = "La disponibilidad no puede ser vacío")
    private int idStateBook;
    @NotNull(message = "El id de categoria no puede ser nulo")
    @NotBlank(message = "El id de categoria no puede ser vacío")
    private int idCategory;
    @NotNull(message = "La sinopsis no puede ser nulo")
    @NotBlank(message = "La sinopsis no puede ser vacío")
    private String sinopsis;
    @NotNull(message = "El archivo no puede ser nulo")
    @NotBlank(message = "El archivo no puede ser vacío")
    private FileDTO file;
    @NotNull(message = "El id de usuario no puede ser nulo")
    @NotBlank(message = "El id de usuario no puede ser vacío")
    private String user;

}
