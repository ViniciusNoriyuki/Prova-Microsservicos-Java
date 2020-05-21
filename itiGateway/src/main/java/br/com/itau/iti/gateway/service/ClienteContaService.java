package br.com.itau.iti.gateway.service;

import br.com.itau.iti.gateway.cliente.model.ClienteSaida;
import br.com.itau.iti.gateway.cliente.service.ClienteService;
import br.com.itau.iti.gateway.conta.model.*;
import br.com.itau.iti.gateway.conta.service.ContaService;
import br.com.itau.iti.gateway.model.ClienteContaEntrada;
import br.com.itau.iti.gateway.model.ClienteContaSaida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteContaService {

    @Autowired
    ClienteService clienteService;

    @Autowired
    ContaService contaService;

    public List<ClienteContaSaida> obterTodosClientesEContas() {

        List<ClienteContaSaida> saida = new ArrayList<>();
        List<ClienteSaida> clientes = clienteService.obterTodos();
        List<ContaSaida> contas = contaService.obterTodos();

        for (int i = 0; i < clientes.size(); i++) {
            ClienteContaSaida clienteContaSaida = new ClienteContaSaida();
            clienteContaSaida.setCliente(clientes.get(i));

            for (ContaSaida contaSaida : contas) {
                if (contaSaida.getClientId() == clientes.get(i).getId()) {
                    clienteContaSaida.getContas().add(contaSaida);
                }
            }

            saida.add(clienteContaSaida);
        }

        return saida;
    }

    public ClienteContaSaida salvarClientesEContas(ClienteContaEntrada clienteContaEntrada) {

        ClienteContaSaida saida = new ClienteContaSaida();

        ClienteSaida cliente = clienteService.salvar(clienteContaEntrada.getCliente());
        saida.setCliente(cliente);

        List<ContaSaida> listaContas = new ArrayList<ContaSaida>();

        for (ContaEntrada contaEntrada : clienteContaEntrada.getContas()) {
            contaEntrada.setClientId(cliente.getId());
            ContaSaida contaSaida = contaService.salvar(contaEntrada);
            listaContas.add(contaSaida);
        }

        saida.setContas(listaContas);

        return saida;
    }

    public ContaSaida saque(Long idCliente, ContaSaqueEntrada contaSaqueEntrada, Long idConta) throws Exception {
        return contaService.saque(idCliente, contaSaqueEntrada, idConta);
    }

    public List<ContaTransacaoSaida> extrato(Long idCliente) {
        return contaService.extrato(idCliente);
    }

    public ContaSaida deposito(Long idCliente, ContaDepositoEntrada contaDepositoEntrada, Long idConta) {
        return contaService.deposito(idCliente, contaDepositoEntrada, idConta);
    }

}