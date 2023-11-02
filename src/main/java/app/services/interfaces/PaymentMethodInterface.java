package app.services.interfaces;

import app.dtos.PaymentMethodDTO;
import app.model.PaymentMethod;

import java.util.List;


public interface PaymentMethodInterface {
    int createPaymentMethod(PaymentMethodDTO paymentMethodDTO) throws Exception;
    int updatePaymentMethod(int paymentMethodId, PaymentMethodDTO paymentMethodGetDTO) throws Exception;
    int deletePaymentMethod(int paymentMethodId) throws Exception;
    List<PaymentMethodDTO> listPaymentMethodByUser(int idUser);
    PaymentMethodDTO getPaymentMethodDTO (int idPaymentMethod) throws Exception;
    PaymentMethod getPaymentMethod(int idPaymentMethod) throws Exception;
    void validateExist(PaymentMethod paymentMethod,int idPaymentMethod) throws Exception;
}
