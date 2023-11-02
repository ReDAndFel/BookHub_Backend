package app.services.interfaces;


import app.dtos.RolDTO;
import app.model.Rol;


public interface RolInterface {
    Rol getRol(int idRol) throws Exception;
    RolDTO getRolDTO(int idRol) throws Exception;
}
