package br.com.itau.iti.contas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.itau.iti.contas.model.ContaEntity;

public interface ContaRepository extends JpaRepository<ContaEntity, Long> {

}