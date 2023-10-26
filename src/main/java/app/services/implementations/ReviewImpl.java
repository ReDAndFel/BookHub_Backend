package app.services.implementations;

import app.dtos.ReviewDTO;
import app.model.Review;
import app.services.interfaces.ReviewInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewImpl implements ReviewInterface {
    @Override
    public int createComment(ReviewDTO reviewDTO) throws Exception {
        return 0;
    }

    @Override
    public List<ReviewDTO> listReviewsByBook(int idBook) {
        return null;
    }

    @Override
    public ReviewDTO getReviewDTO(int idReview) throws Exception {
        return null;
    }

    @Override
    public Review getReview(int idReview) throws Exception {
        return null;
    }
}
