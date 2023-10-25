package app.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PaymentMethod implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(nullable = false)
    String cardNumber;
    @Column(nullable = false)
    String surname;
    @Column(nullable = false)
    LocalDate expeditionDate;
    @Column(nullable = false)
    int cvv;
    @ManyToOne
    User user;
    @Column(nullable = false)
    private  boolean state;
    @OneToMany(mappedBy = "paymentMethod")
    private List<Transaction> transactions;

}
