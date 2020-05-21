package br.com.itau.iti.gateway.conta.feign.client;

import br.com.itau.iti.gateway.conta.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "conta", url = "http://localhost:8084/iti/conta")
public interface ContaClient {

    @GetMapping("/obterTodos")
    public List<ContaSaida> obterTodos();

    @PostMapping("/salvar")
    public ContaSaida salvar(@RequestBody ContaEntrada contaEntrada);

    @PutMapping("/{idCliente}/{idConta}/deposito")
    public ContaSaida deposito(@PathVariable Long idCliente, @PathVariable Long idConta, @RequestBody ContaDepositoEntrada contaDepositoEntrada);

    @PutMapping("/{idCliente}/{idConta}/saque")
    public ContaSaida sacar(@PathVariable Long idCliente, @PathVariable Long idConta, @RequestBody ContaSaqueEntrada contaSaqueEntrada) throws Exception;

    @GetMapping("/{idCliente}/extrato")
    public List<ContaTransacaoSaida> extrato(@PathVariable Long idCliente);

}