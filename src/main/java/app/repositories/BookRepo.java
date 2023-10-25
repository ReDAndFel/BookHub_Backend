package app.repositories;

import app.model.Book;
import app.model.StateBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

    //Poner el estado aprobado con el id 1 en la base de datos para que funcionen estas query
    @Query("select b from Book b where b.category.id = :idCategory and b.available.id = 1 ")
    List<Book> listBookByCategory(int idCategory);

    @Query("select b from Book b where b.available = :stateBook")
    List<Book> listBookByAvailable(StateBook stateBook);

    @Query("select b from Book b join b.userFavorite f where f.id = :idPerson and b.available.id = 1")
    List<Book> listFavoriteBook(String idPerson);

    @Query("select distinct b from User u join u.userLender ul join ul.books b where u.id = :idUser")
    List<Book> listSharedBooksToUser(String idUser);


    @Query("select b from Book b where b.available.id = 1")
    List<Book>listAllBookApproved();

    @Query("select b from Book b where b.price between :minPrice and :maxPrice and b.available.id = 1")
    List<Book> listBookByPrice(float minPrice, float maxPrice);

    @Query("select b from Book b where b.title like concat('%', :title, '%') and b.available.id = 1")
    List<Book> listBookByTitle(String title);

    @Query("select b from Book b where b.user.id = :idPerson and b.available.id = 1")
    List<Book> listBookByUser(String idUser);

}