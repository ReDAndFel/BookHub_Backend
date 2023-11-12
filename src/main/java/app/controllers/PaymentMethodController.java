package app.controllers;

import app.dtos.MessageDTO;
import app.dtos.PaymentMethodDTO;
import app.services.interfaces.PaymentMethodInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/metodo_de_pago")
@CrossOrigin(origins = "*")
public class PaymentMethodController {
    private final PaymentMethodInterface paymentMethodInterface;

    @PostMapping("/agregar")
    public ResponseEntity<MessageDTO> createPaymentMethod(@RequestBody PaymentMethodDTO paymentMethodDTO) throws Exception {
        paymentMethodInterface.createPaymentMethod(paymentMethodDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDTO(HttpStatus.CREATED, false, "Metodo de pago agregado correctamente"));
    }

    @PutMapping("/actualizar/{paymentMethodId}")
    public ResponseEntity<MessageDTO> updatePaymentMethod(@PathVariable int paymentMethodId, @RequestBody PaymentMethodDTO paymentMethodDTO) throws Exception {
        paymentMethodInterface.updatePaymentMethod(paymentMethodId, paymentMethodDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(HttpStatus.OK, false, "Metodo de pago actualizado correctamente"));
    }

    @PutMapping("/eliminar/{paymentMethodId}")
    public ResponseEntity<MessageDTO> deletePaymentMethod(@PathVariable int paymentMethodId) throws Exception {
        paymentMethodInterface.deletePaymentMethod(paymentMethodId);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(HttpStatus.OK, false, "Metodo de pago eliminado correctamente"));
    }

    @GetMapping("/obtener_metodos_de_pago_user/{idUser}")
    public ResponseEntity<MessageDTO> listPaymentMethodByUser(@PathVariable int idUser) {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(HttpStatus.OK, false, paymentMethodInterface.listPaymentMethodByUser(idUser)));
    }

    @GetMapping("/obtener_metodo_de_pago/{idPaymentMethod}")
    public ResponseEntity<MessageDTO> getPaymentMethod(@PathVariable int idPaymentMethod) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(HttpStatus.OK, false, paymentMethodInterface.getPaymentMethodDTO(idPaymentMethod)));
    }
}
