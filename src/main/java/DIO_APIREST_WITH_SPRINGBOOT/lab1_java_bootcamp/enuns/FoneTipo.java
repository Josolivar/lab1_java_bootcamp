package DIO_APIREST_WITH_SPRINGBOOT.lab1_java_bootcamp.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FoneTipo {

    CASA("Casa"),
    CELULAR("Celular"),
    COMERCIAL("Comercial");

    private final String descricao;
}
