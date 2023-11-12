package app.services.implementations;

import app.dtos.SesionDTO;
import app.dtos.TokenDTO;
import app.model.User;
import app.services.interfaces.SesionInterface;
import app.services.interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesionImpl implements SesionInterface {
    @Autowired
    private UserInterface userInterface;

    @Override
    public TokenDTO login(SesionDTO sesionDTO) throws Exception {
        TokenDTO token = null;
        String email = sesionDTO.getEmail();
        String password = sesionDTO.getPassword();
        User user = userInterface.getUserByEmail(email);
        if(user!=null){
            if (user.getPassword().equals(password)==false){
                throw new Exception("No coincide la contraseña. Intente de nuevo.");
            }
            token = new TokenDTO(user.getId(),user.getRol().getId(),user.getUsername());
        }else{
            throw new Exception("No existe ningun usuario con ese correo.");
        }
        return token;
    }

    @Override
    public void logout() {

    }
}
