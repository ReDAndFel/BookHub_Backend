package app.repositories;

import app.model.StateBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateBookRepo extends JpaRepository<StateBook, Integer> {
}
