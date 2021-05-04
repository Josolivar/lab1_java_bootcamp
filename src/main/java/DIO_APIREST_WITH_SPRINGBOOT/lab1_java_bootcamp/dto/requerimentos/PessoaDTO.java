package DIO_APIREST_WITH_SPRINGBOOT.lab1_java_bootcamp.dto.requerimentos;

import DIO_APIREST_WITH_SPRINGBOOT.lab1_java_bootcamp.entidades.Fone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    private long id;

    @Size(min = 1, max = 80, message = "Nome não pode ser vazio!")
    private String nome;

    @Size(min = 1, max = 180, message = "Sobrenome não pode ser vazio!")
    private String sobrenome;

    @CPF(message = "CPF inválido ou inexistente!")
    private String cpf;

    private String dataNascimento;

    @Valid
    private List<Fone> fones;
}
