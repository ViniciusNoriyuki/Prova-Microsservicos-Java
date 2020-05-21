package br.com.itau.iti.gateway.cliente.feign.client;

import br.com.itau.iti.gateway.cliente.model.ClienteEntrada;
import br.com.itau.iti.gateway.cliente.model.ClienteSaida;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "cliente", url = "http://localhost:8082/iti/cliente")
public interface ClienteClient {

    @GetMapping("/obterTodos")
    public List<ClienteSaida> obterTodos();

    @PostMapping("/salvar")
    public ClienteSaida salvar(@RequestBody ClienteEntrada clienteEntrada);

}
