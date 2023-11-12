package app.controllers;

import app.dtos.BookDTO;
import app.dtos.MessageDTO;
import app.services.interfaces.BookInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/mod")
@CrossOrigin(origins = "*")
public class ModController {
    private final BookInterface booktInterface;

    @GetMapping("/obtener_libros_estado/{idStateBook}")
    public ResponseEntity<MessageDTO> listBookByState(@PathVariable int idStateBook){
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,booktInterface.listBookByState(idStateBook)));
    }

    @PutMapping("/revisar_libro/{idBook}")
    public ResponseEntity<MessageDTO> reviewBook(@PathVariable int idBook, @RequestBody BookDTO bookDTO) throws Exception {
        booktInterface.reviewBook(idBook,bookDTO);
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,"Libro revisado correctamente"));
    }
    @GetMapping("/obtener_libros")
    public ResponseEntity<MessageDTO> listAllBooks() throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,booktInterface.listAllBooks()));
    }
}
