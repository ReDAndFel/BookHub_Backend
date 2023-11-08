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
@RequestMapping("/api/libros")
public class BookController {
    private final BookInterface booktInterface;

    @PostMapping("/crear")
    public ResponseEntity<MessageDTO> createProduct(@RequestBody BookDTO bookDTO) throws Exception{
        booktInterface.createBook(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body( new MessageDTO(HttpStatus.OK, false,"Libro creado correctamente"));
    }
    @PutMapping("/actualizar/{idBook}")
    public ResponseEntity<MessageDTO> updateProduct(@PathVariable int idBook, @RequestBody BookDTO bookDTO) throws Exception{
        booktInterface.updateBook(idBook,bookDTO);
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,"Libro actualizado correctamente"));

    }
    @PutMapping("/eliminar/{idBook}")
    public ResponseEntity<MessageDTO> deleteProduct(@PathVariable int idBook) throws Exception{
        booktInterface.deleteBook(idBook);
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,"Libro eliminado correctamente"));

    }
    @PostMapping("/agregar_libro_favorito/{idUser}/{idBook}")
    public ResponseEntity<MessageDTO> addFavoriteProduct(@PathVariable int idUser, @PathVariable int idBook) throws Exception{
        booktInterface.addFavoriteBook(idUser,idBook);
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,"Libro agregado correctamente a favoritos"));
    }
    @DeleteMapping("/quitar_libro_favorito/{idUser}/{idBook}")
    public ResponseEntity<MessageDTO> removeFavoriteProduct(@PathVariable int idUser, @PathVariable int idBook) throws Exception{
        booktInterface.removeFavoriteBook(idUser,idBook);
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,"Libro eliminado correctamente de favoritos"));
    }
    @PostMapping("/compartir_libreria/{idUserLenter}/{idUser}")
    public ResponseEntity<MessageDTO> addSharedBook(@PathVariable int idUserLenter, @PathVariable int idUser) throws Exception{
        booktInterface.addSharedBooks(idUserLenter,idUser);
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,"Libreria compartida correctamente"));
    }
    @DeleteMapping("/descompartir_libreria/{idUser}/{idBook}")
    public ResponseEntity<MessageDTO> removeSharedBook(@PathVariable int idUserLenter, @PathVariable int idUser) throws Exception{
        booktInterface.removeSharedBooks(idUserLenter,idUser);
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,"Libreria dejada de compartir correctamente"));
    }

    @GetMapping("/obtener/{idBook}")
    public ResponseEntity<MessageDTO> getBook(@PathVariable int idBook) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,booktInterface.getBookDTO(idBook)));
    }
    @GetMapping("/obtener_libros_categoria/{idCategory}")
    public ResponseEntity<MessageDTO> listBookByCategory(@PathVariable int idCategory){
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,booktInterface.listBookByCategory(idCategory)));
    }
    @GetMapping("/obtener_libros_usuario/{idUser}")
    public ResponseEntity<MessageDTO> listBookByUser(@PathVariable int idUser){
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,booktInterface.listUserBook(idUser)));
    }
    @GetMapping("/obtener_libros_favoritos/{idUser}")
    public ResponseEntity<MessageDTO> listFavoriteBooks(@PathVariable int idUser){
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,booktInterface.listFavoriteBook(idUser)));
    }
    @GetMapping("/obtener_libros_precio/{minPrice}/{maxPrice}")
    public ResponseEntity<MessageDTO> listBooksByPrice(@PathVariable float minPrice, @PathVariable float maxPrice){
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,booktInterface.listBookByPrice(minPrice,maxPrice)));
    }
    @GetMapping("/obtener_libros_titulo/{title}")
    public ResponseEntity<MessageDTO> listBooksByTitle(@PathVariable String title){
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,booktInterface.listBookByTitle(title)));
    }
    @GetMapping("/obtener_libros_aprobados")
    public ResponseEntity<MessageDTO> listApprovedBooks(){
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,booktInterface.listAllBooksApproved()));
    }
    @GetMapping("/obtener_libros_compartidos/{idUser}")
    public ResponseEntity<MessageDTO> listSharedBooksToUser(@PathVariable int idUser){
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,booktInterface.listSharedBooksToUser(idUser)));
    }
    @GetMapping("/libreria/{idUser}")
    public ResponseEntity<MessageDTO> getLibrary(@PathVariable int idUser){
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,booktInterface.listLibraryUser(idUser)));
    }

}
