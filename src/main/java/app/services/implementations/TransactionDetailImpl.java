package app.services.implementations;

import app.dtos.TransactionDetailDTO;
import app.model.Transaction;
import app.model.TransactionDetail;
import app.services.interfaces.TransactionDetailInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionDetailImpl implements TransactionDetailInterface {

    @Override
    public TransactionDetail createTransactionDetail(TransactionDetailDTO transactionDetailDTO, Transaction transaction) throws Exception {
        return null;
    }

    @Override
    public List<TransactionDetailDTO> listTransactionDetailByTransaction(int idTransaction) {
        return null;
    }

    @Override
    public TransactionDetailDTO getTransactionDetailDTO(int idTransactionDetail) throws Exception {
        return null;
    }

    @Override
    public TransactionDetail getTransactionDetail(int idTransactionDetail) throws Exception {
        return null;
    }
}
