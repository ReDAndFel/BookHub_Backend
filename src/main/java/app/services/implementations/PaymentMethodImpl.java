package app.services.implementations;

import app.dtos.PaymentMethodDTO;
import app.model.PaymentMethod;
import app.services.interfaces.PaymentMethodInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodImpl implements PaymentMethodInterface {
    @Override
    public int createPaymentMethod(PaymentMethodDTO paymentMethodDTO) throws Exception {
        return 0;
    }

    @Override
    public int updatePaymentMethod(int paymentMethodId, PaymentMethodDTO paymentMethodGetDTO) throws Exception {
        return 0;
    }

    @Override
    public int deletePaymentMethod(int paymentMethodId) throws Exception {
        return 0;
    }

    @Override
    public List<PaymentMethodDTO> listPaymentMethodByUser(int idUser) {
        return null;
    }

    @Override
    public PaymentMethodDTO getPaymentMethodDTO(int idPaymentMethod) throws Exception {
        return null;
    }

    @Override
    public PaymentMethod getPaymentMethod(int idPaymentMethod) throws Exception {
        return null;
    }
}
