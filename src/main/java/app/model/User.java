package app.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String address;
    @ManyToOne
    private Rol rol;
    @ManyToMany
    private List<Book> favoriteBook;
    @OneToMany(mappedBy = "user")
    private List<Book> books;

    @OneToMany(mappedBy = "user")
    private List<PaymentMethod> paymentMethods;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;
    @ManyToMany
    private List<User> friend;
    @ManyToMany(mappedBy = "friend")
    private List<User> user;
    @ManyToMany
    private List<User> sharedLibraryUser;
    @ManyToMany(mappedBy = "sharedLibraryUser")
    private List<User> userLender;

}
