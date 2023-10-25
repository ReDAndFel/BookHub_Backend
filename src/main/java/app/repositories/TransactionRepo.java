package app.repositories;

import app.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
    @Query("select t from Transaction t where t.user.id = :idUser")
    List<Transaction> listTransactionByUser(String idUser);
}
