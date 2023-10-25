package app.repositories;

import app.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepo extends JpaRepository<Rol, Integer> {
}
