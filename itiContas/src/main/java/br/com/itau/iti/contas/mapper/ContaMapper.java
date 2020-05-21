package br.com.itau.iti.contas.mapper;

import br.com.itau.iti.contas.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContaMapper {

    ContaMapper INSTANCE = Mappers.getMapper(ContaMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "clientId", target = "clientId"),
            @Mapping(source = "contaId", target = "contaId"),
            @Mapping(source = "saldo_anterior", target = "saldo_anterior"),
            @Mapping(source = "valor_transacao", target = "valor_transacao"),
            @Mapping(source = "saldo_atual", target = "saldo_atual"),
            @Mapping(source = "tipo", target = "tipo")
    })
    ContaTransacaoSaida mapTransacaoToSaida(ContaTransacaoEntity contaTransacaoEntity);

    @Mappings({
            @Mapping(source = "tipo", target = "tipo"),
            @Mapping(source = "agencia", target = "agencia"),
            @Mapping(source = "conta", target = "conta"),
            @Mapping(target = "id", ignore = true)
    })
    ContaEntity mapToEntity(ContaEntrada contaEntrada);

    @Mappings({
            @Mapping(source = "tipo", target = "tipo"),
            @Mapping(source = "agencia", target = "agencia"),
            @Mapping(source = "conta", target = "conta"),
            @Mapping(source = "clientId", target = "clientId"),
            @Mapping(source = "saldo", target = "saldo"),
            @Mapping(source = "id", target = "id")
    })
    ContaSaida mapToSaida(ContaEntity contaEntity);

    List<ContaSaida> mapToSaidaList(List<ContaEntity> listaContaEntity);

}