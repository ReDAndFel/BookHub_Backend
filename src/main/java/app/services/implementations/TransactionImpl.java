package app.services.implementations;

import app.dtos.TransactionDTO;
import app.dtos.TransactionDetailDTO;
import app.model.PaymentMethod;
import app.model.Transaction;
import app.model.TransactionDetail;
import app.model.User;
import app.repositories.TransactionRepo;
import app.services.interfaces.PaymentMethodInterface;
import app.services.interfaces.TransactionDetailInterface;
import app.services.interfaces.TransactionInterface;
import app.services.interfaces.UserInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionImpl implements TransactionInterface {
    @Autowired
    TransactionDetailInterface transactionDetailInterface;
    @Autowired
    PaymentMethodInterface paymentMethodInterface;
    @Autowired
    UserInterface userInterface;
    @Autowired
    TransactionRepo transactionRepo;

    @Transactional(rollbackOn = Exception.class)
    @Override
    public int createTransaction(TransactionDTO transactionDTO) throws Exception {
        Transaction transaction = new Transaction();
        PaymentMethod paymentMethod = paymentMethodInterface.getPaymentMethod(transactionDTO.getIdPaymentMethod());
        transaction.setPaymentMethod(paymentMethod);
        User user = userInterface.getUser(transactionDTO.getIdUser());
        transaction.setUser(user);
        transaction.setDate(LocalDate.now());
        List<TransactionDetail> transactionDetails = new ArrayList<>();
        float priceTotal=0;
        List<TransactionDetailDTO> transactionDetailDTOS = transactionDTO.getTransactionDetailDTOS();
        for (TransactionDetailDTO transactionDetailDTO:transactionDetailDTOS) {
            TransactionDetail transactionDetail = transactionDetailInterface.createTransactionDetail(transactionDetailDTO, transaction);
            transactionDetails.add(transactionDetail);
            priceTotal+=transactionDetail.getPrice();
        }
        transaction.setTransactionDetails(transactionDetails);
        transaction.setTotalPrice(priceTotal);
        return transactionRepo.save(transaction).getId();
    }

    @Override
    public List<TransactionDTO> listTransactionByUser(int idUser) {
        List<Transaction> transactions = transactionRepo.listTransactionByUser(idUser);
        List<TransactionDTO> listTransactionsDTO = new ArrayList<>();
        for (Transaction transaction : transactions) {
            listTransactionsDTO.add(convertToDTO(transaction));
        }
        return listTransactionsDTO;
    }
    @Override
    public TransactionDTO getTransactionDTO(int idTransaction) throws Exception {
        Transaction transaction = transactionRepo.findById(idTransaction).get();
        return convertToDTO(transaction);
    }

    @Override
    public Transaction getTransaction(int idTransaction) throws Exception {
        Transaction transaction = transactionRepo.findById(idTransaction).get();
        return transaction;
    }

    @Override
    public float calculateTotalPrice(List<TransactionDetail> transactionDetails) throws Exception {
        float totalPrice = 0;
        for (TransactionDetail transactionDetail:transactionDetails) {
            totalPrice+=transactionDetail.getPrice();
        }
        return totalPrice;
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

    private TransactionDTO convertToDTO(Transaction transaction) {

        TransactionDTO transactionGetDTO = new TransactionDTO(
                transaction.getId(),
                transaction.getTotalPrice(),
                transaction.getDate().toString(),
                transaction.getPaymentMethod().getId(),
                transactionDetailInterface.listTransactionDetailByTransaction(transaction.getId()),
                transaction.getUser().getId()
        );

        return transactionGetDTO;
    }
}
