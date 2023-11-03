package app.controllers;

import app.dtos.MessageDTO;
import app.dtos.ReviewDTO;
import app.services.interfaces.ReviewInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reseña")
public class ReviewController {
    private final ReviewInterface reviewInterface;

    @PostMapping("/reseñar")
    public ResponseEntity<MessageDTO> createComment(@RequestBody ReviewDTO reviewDTO) throws Exception{
        reviewInterface.createReview(reviewDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDTO(HttpStatus.CREATED,false, "Reseña publicada correctamente"));
    }
    @GetMapping("/obtener_reseñas_libro/{idBook}")
    public ResponseEntity<MessageDTO> listCommentsByProduct(@PathVariable int idBook){
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,reviewInterface.listReviewsByBook(idBook)));
    }
}
