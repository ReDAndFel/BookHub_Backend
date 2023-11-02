package app.controllers;

import app.dtos.MessageDTO;
import app.dtos.TransactionDTO;
import app.services.interfaces.TransactionInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/transaccion")
public class TransactionController {
    private final TransactionInterface transactionInterface;

    @PostMapping("/crear")
    public ResponseEntity<MessageDTO> createTransaction(@RequestBody TransactionDTO transactionDTO) throws Exception{
        transactionInterface.createTransaction(transactionDTO);
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.CREATED, false,"Transaccion creada correctamente"));

    }

    @GetMapping("/obtener_transaction_person/{idUser}")
    public ResponseEntity<MessageDTO> listTransactionByUser(@PathVariable int idUser){
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,transactionInterface.listTransactionByUser(idUser)));
    }

    @GetMapping("/obtener/{idTransaction}")
    public ResponseEntity<MessageDTO> getTransactionDTO(@PathVariable int idTransaction) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,transactionInterface.getTransactionDTO(idTransaction)));
    }

}
