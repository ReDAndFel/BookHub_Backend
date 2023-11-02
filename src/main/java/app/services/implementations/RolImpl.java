package app.services.implementations;

import app.dtos.RolDTO;
import app.model.Rol;
import app.repositories.RolRepo;
import app.services.interfaces.RolInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolImpl implements RolInterface {
    @Autowired
    private RolRepo rolRepo;

    @Override
    public Rol getRol(int idRol) throws Exception {
        Rol rol = rolRepo.findById(idRol).get();
        return rol;
    }

    @Override
    public RolDTO getRolDTO(int idRol) throws Exception {
        Rol rol = rolRepo.findById(idRol).get();
        RolDTO rolDTO = new RolDTO(rol.getId(), rol.getDescripcion());
        return null;
    }
}
