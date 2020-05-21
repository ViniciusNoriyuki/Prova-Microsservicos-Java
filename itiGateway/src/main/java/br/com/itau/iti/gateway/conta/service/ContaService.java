package br.com.itau.iti.gateway.conta.service;

import br.com.itau.iti.gateway.conta.feign.client.ContaClient;
import br.com.itau.iti.gateway.conta.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    ContaClient contaClient;

    public List<ContaSaida> obterTodos() {
        return contaClient.obterTodos();
    }

    public ContaSaida salvar(ContaEntrada contaEntrada) {
        return contaClient.salvar(contaEntrada);
    }

    public ContaSaida deposito(Long idCliente, ContaDepositoEntrada contaDepositoEntrada, Long idConta) {
        return contaClient.deposito(idCliente, idConta, contaDepositoEntrada);
    }

    public ContaSaida saque(Long idCliente, ContaSaqueEntrada contaSaqueEntrada, Long idConta) throws Exception {
        return contaClient.sacar(idCliente, idConta, contaSaqueEntrada);
    }

    public List<ContaTransacaoSaida> extrato(Long clienteId) {
        return contaClient.extrato(clienteId);
    }

}