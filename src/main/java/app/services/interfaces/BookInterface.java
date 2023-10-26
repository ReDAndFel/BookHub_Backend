package app.services.interfaces;

import app.dtos.BookDTO;
import app.model.Book;

import java.util.List;


public interface BookInterface {
    int createBook(BookDTO bookDTO) throws Exception;
    int updateBook(int idBook, BookDTO bookDTO) throws Exception;
    int deleteBook(int idBook) throws Exception;
    BookDTO getBookDTO(int idBook) throws Exception;
    Book getBook(int idBook) throws Exception;
    public List<BookDTO> listBookByCategory(int idCategory);
    public List<BookDTO> listBookByState( int idStateProduct);
    List<BookDTO> listUserBook(int idUser);
    List<BookDTO> listFavoriteBook(int idUser);
    List<BookDTO> listBookByPrice(float minPrice, float maxPrice);
    List<BookDTO> listBookByTitle(String title);
    List<BookDTO> listAllBooks();
    List<BookDTO> listAllBooksApproved();
    int calculatePuntuation(int idBook) throws Exception;
    int reviewBook(int idBook, BookDTO bookDTO) throws Exception;
    void addFavoriteBook(int idUser, int idBook) throws Exception;
    void removeFavoriteBook(int idUser, int idBook) throws Exception;
    void addSharedBooks(int idUserLender,int idUser) throws Exception;
    void removeSharedBooks(int idUser, int idBook) throws Exception;
    List<BookDTO> listSharedBooksToUser(int idUser);
}
