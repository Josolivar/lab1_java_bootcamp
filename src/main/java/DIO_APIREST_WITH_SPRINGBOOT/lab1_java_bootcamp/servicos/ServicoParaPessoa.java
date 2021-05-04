package DIO_APIREST_WITH_SPRINGBOOT.lab1_java_bootcamp.servicos;

import DIO_APIREST_WITH_SPRINGBOOT.lab1_java_bootcamp.dto.requerimentos.PessoaDTO;
import DIO_APIREST_WITH_SPRINGBOOT.lab1_java_bootcamp.dto.respostas.MensagemRespostaDTO;
import DIO_APIREST_WITH_SPRINGBOOT.lab1_java_bootcamp.entidades.Pessoa;
import DIO_APIREST_WITH_SPRINGBOOT.lab1_java_bootcamp.excecoes.PersonNotFoundException;
import DIO_APIREST_WITH_SPRINGBOOT.lab1_java_bootcamp.mapper.MapperPessoa;
import DIO_APIREST_WITH_SPRINGBOOT.lab1_java_bootcamp.repositorios.RepositorioDePessoas;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ServicoParaPessoa {

    private RepositorioDePessoas repositorioPessoas;

    private final MapperPessoa mapperPessoa = MapperPessoa.INSTANCE;

    public MensagemRespostaDTO criarPessoa(PessoaDTO pessoaDTO) {
        return retornaMensagemRespostaDTO( repositorioPessoas.save(mapperPessoa.toModel(pessoaDTO)).getId(), "Criada pessoa com ID: " );

    }

    public List<PessoaDTO> listarPessoas() {
        List<Pessoa> todasAsPessoas = repositorioPessoas.findAll();
        return todasAsPessoas
                .stream()
                .map(mapperPessoa::toDTO)
                .collect(Collectors.toList());
    }

    public PessoaDTO buscarPessoaPorId(long id) throws PersonNotFoundException {
        return mapperPessoa.toDTO(buscarPessoaVerificandoSeElaExiste(id));
    }

    public MensagemRespostaDTO atualizarPessoa(long id, PessoaDTO pessoaDTO) throws PersonNotFoundException {
        buscarPessoaVerificandoSeElaExiste(id);
        repositorioPessoas.save( mapperPessoa.toModel(pessoaDTO) );
        return retornaMensagemRespostaDTO(id, "Atualizada pessoa com ID: ");
    }

    public void deletarPorId(long id) throws PersonNotFoundException {
        repositorioPessoas.deleteById(buscarPessoaVerificandoSeElaExiste(id).getId());
    }

    private Pessoa buscarPessoaVerificandoSeElaExiste(long id) throws PersonNotFoundException {
        return repositorioPessoas
                .findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MensagemRespostaDTO retornaMensagemRespostaDTO(long id, String mensagem) {
        return MensagemRespostaDTO
                .builder()
                .mensagem(mensagem + id)
                .build();
    }
}