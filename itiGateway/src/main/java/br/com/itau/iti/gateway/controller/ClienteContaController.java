package br.com.itau.iti.gateway.controller;

import br.com.itau.iti.gateway.conta.model.ContaDepositoEntrada;
import br.com.itau.iti.gateway.conta.model.ContaSaida;
import br.com.itau.iti.gateway.conta.model.ContaSaqueEntrada;
import br.com.itau.iti.gateway.conta.model.ContaTransacaoSaida;
import br.com.itau.iti.gateway.model.ClienteContaEntrada;
import br.com.itau.iti.gateway.model.ClienteContaSaida;
import br.com.itau.iti.gateway.service.ClienteContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "iti/gateway/clientes/contas", produces = "application/json")
@Configuration
@CrossOrigin
public class ClienteContaController {

    @Autowired
    ClienteContaService clienteContaService;

    @GetMapping("/obterTodosClientesESuasContas")
    public List<ClienteContaSaida> obterTodosClientesESuasContas() {
        return clienteContaService.obterTodosClientesEContas();
    }

    @PostMapping("/salvarClienteESuasContas")
    public ClienteContaSaida salvarClientesESuasContas(@RequestBody ClienteContaEntrada clienteContaEntrada) {
        return clienteContaService.salvarClientesEContas(clienteContaEntrada);
    }

    @PutMapping("/{idCliente}/{idConta}/deposito")
    public ContaSaida deposito(@PathVariable Long idCliente, @PathVariable Long idConta, @RequestBody ContaDepositoEntrada contaDepositoEntrada) {
        return clienteContaService.deposito(idCliente, contaDepositoEntrada, idConta);
    }

    @PutMapping("/{idCliente}/{idConta}/saque")
    public ContaSaida saque(@PathVariable Long idCliente, @PathVariable Long idConta, @RequestBody ContaSaqueEntrada contaSaqueEntrada) throws Exception {
        return clienteContaService.saque(idCliente, contaSaqueEntrada, idConta);
    }

    @GetMapping("/{idCliente}/extrato")
    public List<ContaTransacaoSaida> extrato(@PathVariable Long idCliente) {
        return clienteContaService.extrato(idCliente);
    }

}