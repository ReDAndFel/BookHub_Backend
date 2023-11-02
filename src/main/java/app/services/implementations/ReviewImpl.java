package app.services.implementations;

import app.dtos.ReviewDTO;
import app.model.Book;
import app.model.Review;
import app.model.User;
import app.repositories.ReviewRepo;
import app.services.interfaces.BookInterface;
import app.services.interfaces.ReviewInterface;
import app.services.interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewImpl implements ReviewInterface {
    @Autowired
    private ReviewRepo reviewRepo;
    @Autowired
    private UserInterface userInterface;
    @Autowired
    private BookInterface bookInterface;

    @Override
    public int createReview(ReviewDTO reviewDTO) throws Exception {
        Review review = new Review();
        Book book = bookInterface.getBook(reviewDTO.getIdBook());
        review.setPuntuation(reviewDTO.getPuntuation());
        review.setReview(reviewDTO.getReview());
        review.setDate(LocalDate.now());
        User user = userInterface.getUser(reviewDTO.getIdUser());
        review.setUser(user);
        review.setBook(book);
        reviewRepo.save(review);
        bookInterface.calculatePuntuation(book.getId());
        return review.getId();
    }

    @Override
    public List<ReviewDTO> listReviewsByBook(int idBook) {
        List<Review> listReview = reviewRepo.findByBook(idBook);
        List<ReviewDTO> listReviewDTO = new ArrayList<>();
        for (Review review : listReview) {
            listReviewDTO.add(convertToDTO(review));
        }
        return listReviewDTO;
    }

    @Override
    public ReviewDTO getReviewDTO(int idReview) throws Exception {
        Review review = reviewRepo.findById(idReview).get();
        return convertToDTO(review);
    }

    @Override
    public Review getReview(int idReview) throws Exception {
        Review review = reviewRepo.findById(idReview).get();
        return review;
    }

    private ReviewDTO convertToDTO(Review review) {
        ReviewDTO commentGetDTO = new ReviewDTO(
                review.getId(),
                review.getPuntuation(),
                review.getReview(),
                review.getDate().toString(),
                review.getBook().getId(),
                review.getUser().getId()
        );
        return commentGetDTO;
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
}
