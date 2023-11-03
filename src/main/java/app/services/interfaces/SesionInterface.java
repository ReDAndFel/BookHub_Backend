package app.services.interfaces;

import app.dtos.SesionDTO;
import app.dtos.TokenDTO;

public interface SesionInterface {
    TokenDTO login(SesionDTO sesionDTO) throws Exception;
    void logout();
}
