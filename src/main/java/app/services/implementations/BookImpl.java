package app.services.implementations;

import app.dtos.BookDTO;
import app.dtos.FileDTO;
import app.dtos.ImageDTO;
import app.model.*;
import app.repositories.BookRepo;
import app.repositories.UserRepo;
import app.services.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookImpl implements BookInterface {
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private UserInterface userInterface;
    @Autowired
    private CategoryInterface categoryInterface;
    @Autowired
    private StateBookInterface stateBookInterface;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    FileInterface fileInterface;

    @Override
    public int createBook(BookDTO bookDTO) throws Exception {
        Book book = new Book();
        book.setImage(convertImageDTO(bookDTO.getImage()));
        book.setTitle(bookDTO.getTitle());
        book.setAutor(bookDTO.getAutor());
        book.setEditorial(bookDTO.getEditorial());
        book.setRealeaseDate(convertDate(bookDTO.getRealeaseDate()));
        book.setPuntuation(0);
        book.setPrice(bookDTO.getPrice());
        StateBook stateBook = stateBookInterface.getStateBook(1);
        book.setAvailable(stateBook);
        Category category = categoryInterface.getCategory(bookDTO.getIdCategory());
        book.setCategory(category);
        book.setSinopsis(bookDTO.getSinopsis());
        book.setFile(convertFileDTO(bookDTO.getFile()));
        User user = userInterface.getUser(bookDTO.getIdUser());
        book.setUser(user);
        bookRepo.save(book);
        return book.getId();
    }

    private Map<String, String> convertFileDTO(FileDTO fileDTO) {
        Map<String, String> map = new HashMap<>();
        map.put(fileDTO.getId(), fileDTO.getUrl());
        return map;
    }

    private FileDTO convertFile(Map<String, String> map) {
        FileDTO fileDTO = null;
        for (String key : map.keySet()) {
            fileDTO = new FileDTO(key, map.get(key));
        }
        return fileDTO;
    }

    private Map<String, String> convertImageDTO(ImageDTO imageDTO) {
        Map<String, String> map = new HashMap<>();
        map.put(imageDTO.getId(), imageDTO.getUrl());
        return map;
    }

    private ImageDTO convertImage(Map<String, String> map) {
        ImageDTO imageDTO = null;
        for (String key : map.keySet()) {
            imageDTO = new ImageDTO(key, map.get(key));
        }
        return imageDTO;
    }

    private LocalDate convertDate(String fecha) {
        LocalDate fechaLocalDate = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            fechaLocalDate = LocalDate.parse(fecha, formatter);
        } catch (Exception e) {
            System.out.println("Error al convertir la fecha: " + e.getMessage());
        }
        return fechaLocalDate;
    }

    @Override
    public int updateBook(int idBook, BookDTO bookDTO) throws Exception {
        Book foundBook = getBook(idBook);
        validateExist(foundBook, idBook);
        foundBook.setImage(convertImageDTO(bookDTO.getImage()));
        foundBook.setTitle(bookDTO.getTitle());
        foundBook.setAutor(bookDTO.getAutor());
        foundBook.setEditorial(bookDTO.getEditorial());
        foundBook.setRealeaseDate(convertDate(bookDTO.getRealeaseDate()));
        foundBook.setPrice(bookDTO.getPrice());
        StateBook stateBook = stateBookInterface.getStateBook((bookDTO.getIdStateBook()));
        foundBook.setAvailable(stateBook);
        Category category = categoryInterface.getCategory(bookDTO.getIdCategory());
        foundBook.setCategory(category);
        foundBook.setSinopsis(bookDTO.getSinopsis());
        foundBook.setFile(convertFileDTO(bookDTO.getFile()));
        bookRepo.save(foundBook);
        return foundBook.getId();
    }

    @Override
    public int deleteBook(int idBook) throws Exception {
        Book foundBook = getBook(idBook);
        validateExist(foundBook, idBook);
        StateBook stateBook = stateBookInterface.getStateBook(3);
        foundBook.setAvailable(stateBook);
        bookRepo.save(foundBook);
        return foundBook.getId();
    }

    @Override
    public BookDTO getBookDTO(int idBook) throws Exception {
        Book book = bookRepo.findById(idBook).get();
        BookDTO bookDTO = convertToDTO(book);
        return bookDTO;
    }

    @Override
    public Book getBook(int idBook) throws Exception {
        Book book = bookRepo.findById(idBook).get();
        return book;
    }

    @Override
    public List<BookDTO> listBookByCategory(int idCategory) {
        List<Book> bookList = bookRepo.listBookByCategory(idCategory);
        List<BookDTO> bookDTOList = new ArrayList<>();
        for (Book book : bookList) {
            bookDTOList.add(convertToDTO(book));
        }
        return bookDTOList;
    }

    private BookDTO convertToDTO(Book book) {
        BookDTO bookDTO = new BookDTO(
                book.getId(),
                convertImage(book.getImage()),
                book.getTitle(),
                book.getAutor(), book.getEditorial(),
                book.getRealeaseDate().toString(),
                book.getPuntuation(),
                book.getPrice(),
                book.getAvailable().getId(),
                book.getCategory().getId(),
                book.getSinopsis(),
                convertFile(book.getFile()),
                book.getUser().getId()
        );
        return bookDTO;
    }

    @Override
    public List<BookDTO> listBookByState(int idStateBook) {
        List<Book> bookList = bookRepo.listBookByState(idStateBook);
        List<BookDTO> bookDTOList = new ArrayList<>();
        for (Book book : bookList) {
            bookDTOList.add(convertToDTO(book));
        }
        return bookDTOList;
    }

    @Override
    public List<BookDTO> listUserBook(int idUser) {
        List<Book> bookList = bookRepo.listBookByUser(idUser);
        List<BookDTO> bookDTOList = new ArrayList<>();
        for (Book book : bookList) {
            bookDTOList.add(convertToDTO(book));
        }
        return bookDTOList;
    }

    @Override
    public List<BookDTO> listFavoriteBook(int idUser) {
        List<Book> bookList = bookRepo.listFavoriteBook(idUser);
        List<BookDTO> bookDTOList = new ArrayList<>();
        for (Book book : bookList) {
            bookDTOList.add(convertToDTO(book));
        }
        return bookDTOList;
    }

    @Override
    public List<BookDTO> listBookByPrice(float minPrice, float maxPrice) {
        List<Book> bookList = bookRepo.listBookByPrice(minPrice, maxPrice);
        List<BookDTO> bookDTOList = new ArrayList<>();
        for (Book book : bookList) {
            bookDTOList.add(convertToDTO(book));
        }
        return bookDTOList;
    }

    @Override
    public List<BookDTO> listBookByTitle(String title) {
        List<Book> bookList = bookRepo.listBookByTitle(title);
        List<BookDTO> bookDTOList = new ArrayList<>();
        for (Book book : bookList) {
            bookDTOList.add(convertToDTO(book));
        }
        return bookDTOList;
    }

    @Override
    public List<BookDTO> listAllBooks() {
        List<Book> bookList = bookRepo.findAll();
        List<BookDTO> bookDTOList = new ArrayList<>();
        for (Book book : bookList) {
            bookDTOList.add(convertToDTO(book));
        }
        return bookDTOList;
    }

    @Override
    public List<BookDTO> listAllBooksApproved() {
        List<Book> bookList = bookRepo.listAllBookApproved();
        List<BookDTO> bookDTOList = new ArrayList<>();
        for (Book book : bookList) {
            bookDTOList.add(convertToDTO(book));
        }
        return bookDTOList;
    }

    @Override
    public int calculatePuntuation(int idBook) throws Exception {
        Book foundBook = getBook(idBook);
        float puntuation = 0;
        int cont = 0;
        validateExist(foundBook, idBook);
        List<Review> reviews = foundBook.getReviews();
        for (Review review : reviews) {
            puntuation += review.getPuntuation();
            cont++;
        }
        float puntuationTotal = (puntuation / cont);
        foundBook.setPuntuation(puntuationTotal);
        bookRepo.save(foundBook);
        return foundBook.getId();
    }

    @Override
    public void validateExist(Book foundBook, int idBook) throws Exception {
        if (foundBook == null) {
            throw new Exception("No existe un libro con el id " + idBook);
        }
    }

    @Override
    public int reviewBook(int idBook, BookDTO bookDTO) throws Exception {
        Book foundBook = getBook(idBook);
        validateExist(foundBook, idBook);
        StateBook stateBook = stateBookInterface.getStateBook(bookDTO.getIdStateBook());
        foundBook.setAvailable(stateBook);
        bookRepo.save(foundBook);
        return foundBook.getId();
    }

    @Override
    public void addFavoriteBook(int idUser, int idBook) throws Exception {
        User foundUser = userInterface.getUser(idUser);
        if (foundUser == null) {
            throw new Exception("No se encontro un usuario con el id " + idUser);
        }
        Book foundBook = getBook(idBook);
        validateExist(foundBook, idBook);
        foundUser.getFavoriteBook().add(foundBook);
        userRepo.save(foundUser);
    }

    @Override
    public void removeFavoriteBook(int idUser, int idBook) throws Exception {
        User foundUser = userInterface.getUser(idUser);
        userInterface.validateExist(foundUser, idUser);
        Book foundBook = getBook(idBook);
        validateExist(foundBook, idBook);
        List<Book> favoriteBooks = foundUser.getFavoriteBook();
        int cont = 0;
        for (Book book : favoriteBooks) {
            if (book.getId() == foundBook.getId()) {
                favoriteBooks.remove(cont);
                break;
            }
            cont++;
        }
        userRepo.save(foundUser);
    }

    @Override
    public void addSharedBooks(int idUserLender, int idUser) throws Exception {
        User userLender = userInterface.getUser(idUserLender);
        User user = userInterface.getUser(idUser);
        userInterface.validateExist(userLender, idUserLender);
        userInterface.validateExist(user, idUser);
        List<User> listSharedLibrary = userLender.getSharedLibraryUser();
        listSharedLibrary.add(user);
        userRepo.save(userLender);
    }

    @Override
    public void removeSharedBooks(int idUserLender, int idUser) throws Exception {
        User userLender = userInterface.getUser(idUserLender);
        User user = userInterface.getUser(idUser);
        userInterface.validateExist(userLender, idUserLender);
        userInterface.validateExist(user, idUser);
        List<User> listSharedLibrary = userLender.getSharedLibraryUser();
        int cont = 0;
        for (User userAux : listSharedLibrary) {
            if (userAux.getId() == user.getId()) {
                listSharedLibrary.remove(cont);
                break;
            }
            cont++;
        }
        userRepo.save(userLender);
    }

    @Override
    public List<BookDTO> listSharedBooksToUser(int idUser) {
        List<Book> bookList = bookRepo.listSharedBooksToUser(idUser);
        List<BookDTO> bookDTOList = new ArrayList<>();
        for (Book book : bookList) {
            bookDTOList.add(convertToDTO(book));
        }
        return bookDTOList;
    }

    @Override
    public List<BookDTO> listLibraryUser(int idUser) {
        List<BookDTO> bookBoughtList = listUserBook(idUser);
        List<BookDTO> bookSharedList = listSharedBooksToUser(idUser);
        List<BookDTO> bookListLibrary = new ArrayList<>();
        bookListLibrary.addAll(bookBoughtList);
        bookListLibrary.addAll(bookSharedList);
        return bookListLibrary;
    }

}
