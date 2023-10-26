package app.services.implementations;

import app.dtos.TransactionDTO;
import app.model.Transaction;
import app.model.TransactionDetail;
import app.services.interfaces.TransactionInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionImpl implements TransactionInterface {
    @Override
    public int createTransaction(TransactionDTO transactionDTO) throws Exception {
        return 0;
    }

    @Override
    public List<TransactionDTO> listTransactionByUser(int idPerson) {
        return null;
    }

    @Override
    public TransactionDTO getTransactionDTO(int idTransaction) throws Exception {
        return null;
    }

    @Override
    public Transaction getTransaction(int idTransaction) throws Exception {
        return null;
    }

    @Override
    public float calculateTotalPrice(List<TransactionDetail> transactionDetails) throws Exception {
        return 0;
    }
}
