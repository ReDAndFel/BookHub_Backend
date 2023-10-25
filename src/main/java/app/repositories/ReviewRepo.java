package app.repositories;

import app.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {
    @Query("select c from Review c where c.book.id = :idBook")
    List<Review> findByBook(int idBook);
}
