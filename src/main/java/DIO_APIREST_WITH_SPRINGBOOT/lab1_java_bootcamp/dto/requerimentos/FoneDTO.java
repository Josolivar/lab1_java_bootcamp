package DIO_APIREST_WITH_SPRINGBOOT.lab1_java_bootcamp.dto.requerimentos;

import DIO_APIREST_WITH_SPRINGBOOT.lab1_java_bootcamp.enuns.FoneTipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoneDTO {

    private long id;

    @Enumerated(EnumType.STRING)
    private FoneTipo tipo;

    @Size(min = 8, max = 15, message = "Número do telefone não pode ser vazio!")
    private String numero;
}
