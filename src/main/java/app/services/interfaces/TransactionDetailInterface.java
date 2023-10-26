package app.services.interfaces;

import app.dtos.TransactionDetailDTO;
import app.model.Transaction;
import app.model.TransactionDetail;

import java.util.List;


public interface TransactionDetailInterface {
    TransactionDetail createTransactionDetail(TransactionDetailDTO transactionDetailDTO, Transaction transaction) throws Exception;
    List<TransactionDetailDTO> listTransactionDetailByTransaction(int idTransaction);
    TransactionDetailDTO getTransactionDetailDTO(int idTransactionDetail) throws Exception;
    TransactionDetail getTransactionDetail(int idTransactionDetail) throws Exception;
}
