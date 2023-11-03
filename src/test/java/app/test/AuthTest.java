package app.test;

import app.dtos.SesionDTO;
import app.dtos.TokenDTO;
import app.services.interfaces.SesionInterface;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Transactional
@AllArgsConstructor
public class AuthTest {
    SesionInterface sesionInterface;
    @Test
    @Sql("classpath:dataset.sql")
    public void login() throws Exception {
        SesionDTO sesionDTO = new SesionDTO("pipecar366@gmail.com","1234");
        TokenDTO tokenDTO = sesionInterface.login(sesionDTO);
        System.out.println("token: " + tokenDTO.toString());
        Assertions.assertNotNull(tokenDTO);
    }
}
