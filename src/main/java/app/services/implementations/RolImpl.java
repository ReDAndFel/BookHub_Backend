package app.services.implementations;

import app.dtos.RolDTO;
import app.model.Rol;
import app.services.interfaces.RolInterface;
import org.springframework.stereotype.Service;

@Service
public class RolImpl implements RolInterface {
    @Override
    public Rol getCategory(int idRol) throws Exception {
        return null;
    }

    @Override
    public RolDTO getRolDTO(int idRol) throws Exception {
        return null;
    }
}
