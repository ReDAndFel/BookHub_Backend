package app.services.implementations;

import app.dtos.EmailDTO;
import app.services.interfaces.EmailInterface;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class EmailImpl implements EmailInterface {
    private final  JavaMailSender javaMailSender;
    @Override
    public void sendEmail(EmailDTO emailDTO) throws Exception {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try{
            helper.setSubject(emailDTO.getSubject());
            helper.setText(emailDTO.getBody(), true);
            helper.setTo(emailDTO.getReceiver());
            helper.setFrom("no_reply@dominio.com");
            javaMailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
