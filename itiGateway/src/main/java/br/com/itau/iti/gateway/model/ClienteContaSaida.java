package br.com.itau.iti.gateway.model;

import br.com.itau.iti.gateway.cliente.model.ClienteSaida;
import br.com.itau.iti.gateway.conta.model.ContaSaida;

import java.util.ArrayList;
import java.util.List;

public class ClienteContaSaida {
    ClienteSaida cliente;
    List<ContaSaida> contas = new ArrayList<ContaSaida>();

    public ClienteSaida getCliente() {
        return cliente;
    }

    public void setCliente(ClienteSaida cliente) {
        this.cliente = cliente;
    }

    public List<ContaSaida> getContas() {
        return contas;
    }

    public void setContas(List<ContaSaida> contas) {
        this.contas = contas;
    }

}