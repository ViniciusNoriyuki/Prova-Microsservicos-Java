package br.com.itau.iti.clientes.repository;

import br.com.itau.iti.clientes.model.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

}

