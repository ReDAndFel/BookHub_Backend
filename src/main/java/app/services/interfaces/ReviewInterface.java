package app.services.interfaces;

import app.dtos.ReviewDTO;
import app.model.Review;

import java.util.List;


public interface ReviewInterface {
    int createReview(ReviewDTO reviewDTO) throws Exception;
    List<ReviewDTO> listReviewsByBook(int idBook);
    ReviewDTO getReviewDTO(int idReview) throws Exception;
    Review getReview(int idReview) throws Exception;
}
