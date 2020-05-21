package br.com.itau.iti.clientes.mapper;

import br.com.itau.iti.clientes.model.ClienteEntity;
import br.com.itau.iti.clientes.model.ClienteEntrada;
import br.com.itau.iti.clientes.model.ClienteSaida;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    @Mappings({
            @Mapping(source = "nome", target = "nome"),
            @Mapping(target = "id", ignore = true)
    })
    ClienteEntity mapToEntity(ClienteEntrada clienteEntrada);

    @Mappings({
            @Mapping(source = "nome", target = "nome"),
            @Mapping(source = "id", target = "id")
    })
    ClienteSaida mapToSaida(ClienteEntity clienteEntity);

    List<ClienteSaida> mapToSaidaList(List<ClienteEntity> listaClienteEntity);

}