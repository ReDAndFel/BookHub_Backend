package app.services.interfaces;

import app.dtos.TransactionDTO;
import app.model.Transaction;
import app.model.TransactionDetail;

import java.util.List;


public interface TransactionInterface {
    int createTransaction(TransactionDTO transactionDTO) throws Exception;
    List<TransactionDTO> listTransactionByUser(int idUser);
    TransactionDTO getTransactionDTO(int idTransaction) throws Exception;
    Transaction getTransaction (int idTransaction) throws Exception;
    float calculateTotalPrice(List<TransactionDetail> transactionDetails) throws Exception;
}
