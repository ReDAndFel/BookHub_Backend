package app.services.interfaces;

import app.dtos.StateBookDTO;
import app.model.StateBook;



public interface StateBookInterface {
    StateBook getStateBook(int idStateBook) throws Exception;
    StateBookDTO getStateBookDTO(int idStateBook) throws Exception;
}
