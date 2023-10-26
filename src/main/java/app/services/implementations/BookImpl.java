package app.services.implementations;

import app.dtos.BookDTO;
import app.model.Book;
import app.services.interfaces.BookInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookImpl implements BookInterface {

    @Override
    public int createBook(BookDTO bookDTO) throws Exception {
        return 0;
    }

    @Override
    public int updateBook(int idBook, BookDTO bookDTO) throws Exception {
        return 0;
    }

    @Override
    public int deleteBook(int idBook) throws Exception {
        return 0;
    }

    @Override
    public BookDTO getBookDTO(int idBook) throws Exception {
        return null;
    }

    @Override
    public Book getBook(int idBook) throws Exception {
        return null;
    }

    @Override
    public List<BookDTO> listBookByCategory(int idCategory) {
        return null;
    }

    @Override
    public List<BookDTO> listBookByState(int idStateProduct) {
        return null;
    }

    @Override
    public List<BookDTO> listUserBook(int idUser) {
        return null;
    }

    @Override
    public List<BookDTO> listFavoriteBook(int idUser) {
        return null;
    }

    @Override
    public List<BookDTO> listBookByPrice(float minPrice, float maxPrice) {
        return null;
    }

    @Override
    public List<BookDTO> listBookByTitle(String title) {
        return null;
    }

    @Override
    public List<BookDTO> listAllBooks() {
        return null;
    }

    @Override
    public List<BookDTO> listAllBooksApproved() {
        return null;
    }

    @Override
    public int calculatePuntuation(int idBook) throws Exception {
        return 0;
    }

    @Override
    public int reviewBook(int idBook, BookDTO bookDTO) throws Exception {
        return 0;
    }

    @Override
    public void addFavoriteBook(int idUser, int idBook) throws Exception {

    }

    @Override
    public void removeFavoriteBook(int idUser, int idBook) throws Exception {

    }

    @Override
    public void addSharedBooks(int idUserLender, int idUser) throws Exception {

    }

    @Override
    public void removeSharedBooks(int idUser, int idBook) throws Exception {

    }

    @Override
    public List<BookDTO> listSharedBooksToUser(int idUser) {
        return null;
    }
}
