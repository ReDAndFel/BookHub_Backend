package app.services.implementations;

import app.dtos.TransactionDetailDTO;
import app.model.Book;
import app.model.Transaction;
import app.model.TransactionDetail;
import app.repositories.TransactionDetailRepo;
import app.repositories.TransactionRepo;
import app.services.interfaces.BookInterface;
import app.services.interfaces.TransactionDetailInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionDetailImpl implements TransactionDetailInterface {
    @Autowired
    private BookInterface bookInterface;
    @Autowired
    private TransactionRepo transactionRepo;
    @Autowired
    private TransactionDetailRepo transactionDetailRepo;

    @Override
    public TransactionDetail createTransactionDetail(TransactionDetailDTO transactionDetailDTO, Transaction transaction) throws Exception {
        TransactionDetail transactionDetail = new TransactionDetail();
        transactionDetail.setTransaction(transaction);
        Book book = bookInterface.getBook(transactionDetailDTO.getIdBook());
        transactionDetail.setBook(book);
        transactionDetail.setPrice(transactionDetailDTO.getPrice());
        transactionDetailRepo.save(transactionDetail);
        return transactionDetail;
    }

    @Override
    public List<TransactionDetailDTO> listTransactionDetailByTransaction(int idTransaction) {
        List<TransactionDetail> listTransactionDetailByTransaction = transactionDetailRepo.findByTransaction(idTransaction);
        List<TransactionDetailDTO> listTransactionDetailDTOByTransaction = new ArrayList<>();
        for (TransactionDetail transactionDetail : listTransactionDetailByTransaction) {
            listTransactionDetailDTOByTransaction.add(convertToDTO(transactionDetail));
        }
        return listTransactionDetailDTOByTransaction;
    }

    @Override
    public TransactionDetailDTO getTransactionDetailDTO(int idTransactionDetail) throws Exception {
        TransactionDetail transactionDetail = transactionDetailRepo.findById(idTransactionDetail).get();
        return convertToDTO(transactionDetail);
    }

    @Override
    public TransactionDetail getTransactionDetail(int idTransactionDetail) throws Exception {
        TransactionDetail transactionDetail = transactionDetailRepo.findById(idTransactionDetail).get();
        return transactionDetail;
    }

    private TransactionDetailDTO convertToDTO(TransactionDetail transactionDetail) {
        TransactionDetailDTO transactionDetailGetDTO = new TransactionDetailDTO(
                transactionDetail.getId(),
                transactionDetail.getPrice(),
                transactionDetail.getTransaction().getId(),
                transactionDetail.getBook().getId()
        );
        return transactionDetailGetDTO;
    }
}
