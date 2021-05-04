package DIO_APIREST_WITH_SPRINGBOOT.lab1_java_bootcamp.controladores;

import DIO_APIREST_WITH_SPRINGBOOT.lab1_java_bootcamp.dto.requerimentos.PessoaDTO;
import DIO_APIREST_WITH_SPRINGBOOT.lab1_java_bootcamp.dto.respostas.MensagemRespostaDTO;
import DIO_APIREST_WITH_SPRINGBOOT.lab1_java_bootcamp.excecoes.PersonNotFoundException;
import DIO_APIREST_WITH_SPRINGBOOT.lab1_java_bootcamp.servicos.ServicoParaPessoa;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ControlaPessoas {

    private ServicoParaPessoa servicoParaPessoa;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MensagemRespostaDTO criarPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
        return servicoParaPessoa.criarPessoa(pessoaDTO);
    }

    @GetMapping
    public List<PessoaDTO> listarPessoas() {
        return servicoParaPessoa.listarPessoas();
    }

    @GetMapping("/{id}")
    public PessoaDTO buscarPessoaPorId(@PathVariable long id) throws PersonNotFoundException {
        return servicoParaPessoa.buscarPessoaPorId(id);
    }

    @PutMapping("/{id}")
    public MensagemRespostaDTO atualizarPessoa(@PathVariable long id, @RequestBody @Valid PessoaDTO pessoaDTO) throws PersonNotFoundException {
        return servicoParaPessoa.atualizarPessoa(id, pessoaDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorId(@PathVariable long id) throws PersonNotFoundException {
        servicoParaPessoa.deletarPorId(id);
    }
}