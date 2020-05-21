package br.com.itau.iti.clientes.controller;

import br.com.itau.iti.clientes.model.ClienteEntrada;
import br.com.itau.iti.clientes.model.ClienteSaida;
import br.com.itau.iti.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "iti/cliente", produces = "application/json")
@Configuration
@CrossOrigin
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/obterTodos")
    public List<ClienteSaida> obterTodos() {
        return clienteService.obterTodos();
    }

    @PostMapping("/salvar")
    public ClienteSaida salvar(@RequestBody ClienteEntrada clienteEntrada) {
        return clienteService.salvar(clienteEntrada);
    }

}