package app.services.implementations;

import app.dtos.SesionDTO;
import app.dtos.TokenDTO;
import app.services.interfaces.SesionInterface;
import org.springframework.stereotype.Service;

@Service
public class SesionImpl implements SesionInterface {

    @Override
    public TokenDTO login(SesionDTO sesionDTO) {
        return null;
    }

    @Override
    public void logout() {

    }
}
