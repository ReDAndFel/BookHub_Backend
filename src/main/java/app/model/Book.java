package app.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Book implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @ElementCollection
    private Map<String,String> image;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String autor;
    @Column(nullable = false)
    private String editorial;
    @Column(nullable = false)
    private LocalDate realeaseDate;
    @Column(nullable = false)
    private float puntuation;
    @Column(nullable = false)
    private float price;
    @ManyToOne
    private StateBook available;
    @ManyToOne
    private Category category;
    @Column(nullable = false)
    private String sinopsis;
    @ElementCollection
    private Map<String,String> file;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "book")
    private List<Review> reviews;
    @ManyToMany(mappedBy = "favoriteBook")
    private List<User> userFavorite;
    @OneToMany(mappedBy = "book")
    private List<TransactionDetail> transactionDetails;

}
