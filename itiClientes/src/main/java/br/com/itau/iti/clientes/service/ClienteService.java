package br.com.itau.iti.clientes.service;

import br.com.itau.iti.clientes.mapper.ClienteMapper;
import br.com.itau.iti.clientes.model.ClienteEntity;
import br.com.itau.iti.clientes.model.ClienteEntrada;
import br.com.itau.iti.clientes.model.ClienteSaida;
import br.com.itau.iti.clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<ClienteSaida> obterTodos() {

        List<ClienteEntity> listaClienteEntity = clienteRepository.findAll();

        return ClienteMapper.INSTANCE.mapToSaidaList(listaClienteEntity);
    }

    public ClienteSaida salvar(ClienteEntrada clienteEntrada) {

        ClienteEntity clienteEntity = ClienteMapper.INSTANCE.mapToEntity(clienteEntrada);

        clienteEntity = clienteRepository.save(clienteEntity);

        return ClienteMapper.INSTANCE.mapToSaida(clienteEntity);
    }

}
