package app.services.implementations;

import app.dtos.StateBookDTO;
import app.model.StateBook;
import app.services.interfaces.StateBookInterface;
import org.springframework.stereotype.Service;

@Service
public class StateBookImpl implements StateBookInterface {
    @Override
    public StateBook geStateBook(int idStateBook) throws Exception {
        return null;
    }

    @Override
    public StateBookDTO geStateBookDTO(int idStateBook) throws Exception {
        return null;
    }
}
