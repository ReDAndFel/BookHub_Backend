package app.controllers;

import app.dtos.MessageDTO;
import app.services.interfaces.TransactionDetailInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/detalle_transaccion")
public class TransactionDetailController {
    private final TransactionDetailInterface transactionDetailInterface;
    @GetMapping("/obtener_detalles_transaccion/{idTransaction}")
    public ResponseEntity<MessageDTO> listTransactionDetailByTransaction(@PathVariable int idTransaction){
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,transactionDetailInterface.listTransactionDetailByTransaction(idTransaction)));
    }

}
