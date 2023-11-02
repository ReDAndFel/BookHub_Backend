package app.controllers;

import app.dtos.MessageDTO;
import app.services.interfaces.FileInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/archivo")
public class FileController {
    private final FileInterface fileInterface;
    @PostMapping("/subir_imagen")
    public ResponseEntity<MessageDTO> uploadImage(@RequestParam("file") MultipartFile file)
            throws Exception{
        File image = fileInterface.convert(file);
        Map response = fileInterface.uploadFile(image, "bookHubImages");
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false, response ) );
    }
    @DeleteMapping("/eliminar_archivo/{id}")
    public ResponseEntity<MessageDTO> deleteImage(@PathVariable String id) throws Exception{
        Map response = fileInterface.deleteFile(id);
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false, response ) );
    }
    @PostMapping("/subir_archivo")
    public ResponseEntity<MessageDTO> uploadFile(@RequestParam("file") MultipartFile file)
            throws Exception{
        File fileUpload = fileInterface.convert(file);
        Map response = fileInterface.uploadFile(fileUpload, "bookHubFiles");
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false, response ) );
    }

}
