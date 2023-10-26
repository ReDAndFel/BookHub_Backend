package app.services.interfaces;

import app.dtos.StateBookDTO;
import app.model.StateBook;



public interface StateBookInterface {
    StateBook geStateBook(int idStateBook) throws Exception;
    StateBookDTO geStateBookDTO(int idStateBook) throws Exception;
}
