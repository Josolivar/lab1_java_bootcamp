package DIO_APIREST_WITH_SPRINGBOOT.lab1_java_bootcamp.repositorios;

import DIO_APIREST_WITH_SPRINGBOOT.lab1_java_bootcamp.entidades.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioDePessoas extends JpaRepository<Pessoa, Long> {

}
