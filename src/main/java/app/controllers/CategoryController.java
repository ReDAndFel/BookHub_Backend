package app.controllers;

import app.dtos.MessageDTO;
import app.services.interfaces.CategoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "*")
public class CategoryController {
    private final CategoryInterface categoryInterface;
    @GetMapping("/obtener")
    public ResponseEntity<MessageDTO> listAllCategory(){
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,categoryInterface.listAllCategory()));
    }

    @GetMapping("/obtener/{idCategory}")
    public ResponseEntity<MessageDTO> getCategory(@PathVariable int idCategory) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,categoryInterface.getCategoryDTO(idCategory)));
    }
}
