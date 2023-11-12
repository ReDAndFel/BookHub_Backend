package app.repositories;

import app.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentMethodRepo extends JpaRepository<PaymentMethod, Integer> {
    @Query("select p from PaymentMethod p where p.cardNumber = :cardNumber")
    PaymentMethod findByCardNumber(String cardNumber);

    @Query("select p from PaymentMethod p where p.user.id = :idUser and p.state = true")
    List<PaymentMethod> findByUser(int idUser);
}
