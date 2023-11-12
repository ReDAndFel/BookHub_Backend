package app.repositories;

import app.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {
    @Query("SELECT r, u.username FROM Review r JOIN r.user u WHERE r.book.id = :idBook")
    List<Object[]> findByBook(int idBook);
}
