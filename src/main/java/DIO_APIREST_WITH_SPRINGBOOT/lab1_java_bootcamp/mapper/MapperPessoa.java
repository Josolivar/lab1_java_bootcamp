package DIO_APIREST_WITH_SPRINGBOOT.lab1_java_bootcamp.mapper;

import DIO_APIREST_WITH_SPRINGBOOT.lab1_java_bootcamp.dto.requerimentos.PessoaDTO;
import DIO_APIREST_WITH_SPRINGBOOT.lab1_java_bootcamp.entidades.Pessoa;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapperPessoa {

    MapperPessoa INSTANCE = Mappers.getMapper(MapperPessoa.class);

    @Mapping(target = "dataNascimento", source = "dataNascimento", dateFormat = "dd/MM/yyyy")
    Pessoa toModel(PessoaDTO pessoaDTO);

    PessoaDTO toDTO(Pessoa pessoa);
}
