package DIO_APIREST_WITH_SPRINGBOOT.lab1_java_bootcamp.dto.respostas;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MensagemRespostaDTO {

    private String mensagem;
}
