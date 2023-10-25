package app.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Review implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(nullable = false)
    private int puntuation;

    @Column(nullable = false)
    private String review;

    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne
    private Book book;

    @ManyToOne
    private User user;
    
}
