package app.repositories;

import app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.email = :email")
    User findUserByEmail(String email);

    @Query("select u.friend from User u where u.id = :userId")
    List<User> listUserFriends(int userId);
}
