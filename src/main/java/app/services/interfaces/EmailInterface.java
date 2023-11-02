package app.services.interfaces;

import app.dtos.EmailDTO;

public interface EmailInterface {
    void sendEmail(EmailDTO emailDTO) throws Exception;
}
