package br.com.itau.iti.contas.controller;

import br.com.itau.iti.contas.model.*;
import br.com.itau.iti.contas.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "iti/conta", produces = "application/json")
@Configuration
@CrossOrigin
public class ContaController {

    @Autowired
    ContaService contaService;

    @GetMapping("/obterTodos")
    public List<ContaSaida> obterTodos() {
        return contaService.obterTodos();
    }

    @PostMapping("/salvar")
    public ContaSaida salvar(@RequestBody ContaEntrada contaEntrada) {
        return contaService.salvar(contaEntrada);
    }

    @PutMapping("/{idCliente}/{idConta}/deposito")
    public ContaSaida deposito(@PathVariable Long idCliente, @PathVariable Long idConta, @RequestBody ContaDepositoEntrada contaDepositoEntrada) throws Exception {
        return contaService.deposito(idCliente, contaDepositoEntrada, idConta);
    }

    @PutMapping("/{idCliente}/{idConta}/saque")
    public ContaSaida sacar(@PathVariable Long idCliente, @PathVariable Long idConta, @RequestBody ContaSaqueEntrada contaSaqueEntrada) throws Exception {
        ContaSaida contaSaida = contaService.saque(idCliente, contaSaqueEntrada, idConta);
        return contaSaida;
    }

    @GetMapping("/{idCliente}/extrato")
    public List<ContaTransacaoSaida> extrato(@PathVariable Long idCliente) throws Exception {
        return contaService.extrato(idCliente);
    }

}