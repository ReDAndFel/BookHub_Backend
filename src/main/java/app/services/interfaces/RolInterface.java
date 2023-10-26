package app.services.interfaces;


import app.dtos.RolDTO;
import app.model.Rol;


public interface RolInterface {
    Rol getCategory(int idRol) throws Exception;
    RolDTO getRolDTO(int idRol) throws Exception;
}
