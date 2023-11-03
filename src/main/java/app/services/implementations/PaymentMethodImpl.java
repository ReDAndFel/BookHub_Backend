package app.services.implementations;

import app.dtos.PaymentMethodDTO;
import app.model.PaymentMethod;
import app.model.User;
import app.repositories.PaymentMethodRepo;
import app.services.interfaces.PaymentMethodInterface;
import app.services.interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentMethodImpl implements PaymentMethodInterface {
    @Autowired
    private PaymentMethodRepo paymentMethodRepo;
    @Autowired
    private UserInterface userInterface;

    @Override
    public int createPaymentMethod(PaymentMethodDTO paymentMethodDTO) throws Exception {
        String cardNumber = paymentMethodDTO.getCardNumber();
        PaymentMethod foundPaymentMethod = paymentMethodRepo.findByCardNumber(paymentMethodDTO.getCardNumber());
        validateCard(foundPaymentMethod, cardNumber);
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setCardNumber(paymentMethodDTO.getCardNumber());
        paymentMethod.setCvv(paymentMethodDTO.getCvv());
        paymentMethod.setSurname(paymentMethodDTO.getSurname());
        LocalDate expeditionDate = convertDate(paymentMethodDTO.getExpeditionDate());
        paymentMethod.setExpeditionDate(expeditionDate);
        User user = userInterface.getUser(paymentMethodDTO.getIdUser());
        paymentMethod.setUser(user);
        paymentMethod.setState(true);
        return paymentMethodRepo.save(paymentMethod).getId();
    }

    private LocalDate convertDate(String fecha) {
        LocalDate fechaLocalDate = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            fechaLocalDate = LocalDate.parse(fecha, formatter);
        } catch (Exception e) {
            System.out.println("Error al convertir la fecha: " + e.getMessage());
        }
        return fechaLocalDate;
    }

    private void validateCard(PaymentMethod paymentMethod, String foundPaymentMethod) throws Exception {
        if (paymentMethod.getCardNumber().equals(foundPaymentMethod)) {
            throw new Exception("El metodo de pago ya existe");

        }
    }

    @Override
    public int updatePaymentMethod(int paymentMethodId, PaymentMethodDTO paymentMethodDTO) throws Exception {
        PaymentMethod foundPaymentMethod = paymentMethodRepo.findById(paymentMethodId).get();
        validateExist(foundPaymentMethod, paymentMethodId);
        foundPaymentMethod.setCardNumber(paymentMethodDTO.getCardNumber());
        foundPaymentMethod.setCvv(paymentMethodDTO.getCvv());
        foundPaymentMethod.setSurname(paymentMethodDTO.getSurname());
        LocalDate expeditionDate = convertDate(paymentMethodDTO.getExpeditionDate());
        foundPaymentMethod.setExpeditionDate(expeditionDate);
        return paymentMethodRepo.save(foundPaymentMethod).getId();
    }

    @Override
    public int deletePaymentMethod(int paymentMethodId) throws Exception {
        PaymentMethod foundPaymentMethod = paymentMethodRepo.findById(paymentMethodId).get();
        validateExist(foundPaymentMethod, paymentMethodId);
        foundPaymentMethod.setState(false);
        return paymentMethodRepo.save(foundPaymentMethod).getId();
    }

    @Override
    public List<PaymentMethodDTO> listPaymentMethodByUser(int idUser) {
        List<PaymentMethod> listPaymentMethod = paymentMethodRepo.findByUser(idUser);
        List<PaymentMethodDTO> listPaymentMethodDTO = new ArrayList<>();
        for (PaymentMethod paymentMethod : listPaymentMethod) {
            listPaymentMethodDTO.add(convertToDTO(paymentMethod));
        }
        return listPaymentMethodDTO;
    }

    @Override
    public PaymentMethodDTO getPaymentMethodDTO(int idPaymentMethod) throws Exception {
        PaymentMethod paymentMethod = paymentMethodRepo.findById(idPaymentMethod).get();
        return convertToDTO(paymentMethod);
    }

    @Override
    public PaymentMethod getPaymentMethod(int idPaymentMethod) throws Exception {
        PaymentMethod paymentMethod = paymentMethodRepo.findById(idPaymentMethod).get();
        return paymentMethod;
    }

    @Override
    public void validateExist(PaymentMethod paymentMethod, int idPaymentMethod) throws Exception {
        if (paymentMethod == null) {
            throw new Exception("El metodo de pago con el id " + idPaymentMethod + " no existe");
        }
    }

    private PaymentMethodDTO convertToDTO(PaymentMethod paymentMethod) {

        PaymentMethodDTO paymentMethodDTO = new PaymentMethodDTO(
                paymentMethod.getId(),
                paymentMethod.getCardNumber(),
                paymentMethod.getSurname(),
                paymentMethod.getExpeditionDate().toString().toString(),
                paymentMethod.getCvv(),
                paymentMethod.isState(),
                paymentMethod.getUser().getId()
        );

        return paymentMethodDTO;
    }
}
