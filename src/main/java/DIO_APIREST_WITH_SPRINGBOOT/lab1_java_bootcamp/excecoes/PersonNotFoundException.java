package DIO_APIREST_WITH_SPRINGBOOT.lab1_java_bootcamp.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends Exception {

    public PersonNotFoundException(long id) {
        super("A pessoa com o id " + id + " não foi encontrada.");
    }
}
