package app.services.implementations;

import app.dtos.StateBookDTO;
import app.model.StateBook;
import app.repositories.StateBookRepo;
import app.services.interfaces.StateBookInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateBookImpl implements StateBookInterface {
    @Autowired
    private StateBookRepo stateBookRepo;

    @Override
    public StateBook getStateBook(int idStateBook) throws Exception {
        StateBook stateBook = stateBookRepo.findById(idStateBook).get();
        return stateBook;
    }

    @Override
    public StateBookDTO getStateBookDTO(int idStateBook) throws Exception {
        StateBook stateBook = stateBookRepo.findById(idStateBook).get();
        StateBookDTO stateBookDTO = new StateBookDTO(stateBook.getId(), stateBook.getDescripcion());
        return stateBookDTO;
    }
}
