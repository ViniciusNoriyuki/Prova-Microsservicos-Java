package br.com.itau.iti.gateway.cliente.service;

import br.com.itau.iti.gateway.cliente.feign.client.ClienteClient;
import br.com.itau.iti.gateway.cliente.model.ClienteEntrada;
import br.com.itau.iti.gateway.cliente.model.ClienteSaida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteClient clienteClient;

    public List<ClienteSaida> obterTodos() {
        return clienteClient.obterTodos();
    }

    public ClienteSaida salvar(ClienteEntrada clienteEntrada) {
        return clienteClient.salvar(clienteEntrada);
    }

}
