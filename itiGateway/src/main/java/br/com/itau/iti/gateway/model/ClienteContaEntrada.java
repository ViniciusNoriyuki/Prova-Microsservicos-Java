package br.com.itau.iti.gateway.model;

import br.com.itau.iti.gateway.cliente.model.ClienteEntrada;
import br.com.itau.iti.gateway.conta.model.ContaEntrada;

import java.util.ArrayList;
import java.util.List;

public class ClienteContaEntrada {
    ClienteEntrada cliente;
    List<ContaEntrada> contas = new ArrayList<ContaEntrada>();

    public ClienteEntrada getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntrada cliente) {
        this.cliente = cliente;
    }

    public List<ContaEntrada> getContas() {
        return contas;
    }

    public void setContas(List<ContaEntrada> contas) {
        this.contas = contas;
    }

}
