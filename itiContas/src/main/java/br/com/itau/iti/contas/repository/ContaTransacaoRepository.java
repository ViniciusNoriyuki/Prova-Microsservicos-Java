package br.com.itau.iti.contas.repository;

import br.com.itau.iti.contas.model.ContaTransacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaTransacaoRepository extends JpaRepository<ContaTransacaoEntity, Long> {

}