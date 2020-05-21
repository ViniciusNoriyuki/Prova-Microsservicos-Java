package br.com.itau.iti.contas.service;

import br.com.itau.iti.contas.mapper.ContaMapper;
import br.com.itau.iti.contas.model.*;
import br.com.itau.iti.contas.repository.ContaRepository;
import br.com.itau.iti.contas.repository.ContaTransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContaService {

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    ContaTransacaoRepository contaTransacaoRepository;

    public List<ContaSaida> obterTodos() {

        List<ContaEntity> listaContaEntity = contaRepository.findAll();

        return ContaMapper.INSTANCE.mapToSaidaList(listaContaEntity);
    }

    public ContaSaida salvar(ContaEntrada contaEntrada) {

        ContaEntity contaEntity = ContaMapper.INSTANCE.mapToEntity(contaEntrada);

        contaEntity.setSaldo(0.0);

        contaEntity = contaRepository.save(contaEntity);

        return ContaMapper.INSTANCE.mapToSaida(contaEntity);
    }

    public ContaSaida deposito(Long idCliente, ContaDepositoEntrada contaDepositoEntrada, Long idConta) throws Exception {

        List<ContaEntity> listaContas = contaRepository.findAll();
        if (listaContas.isEmpty()) {
            throw new Exception("Nao ha contas cadastradas.");
        }

        List<ContaEntity> listaContasCliente = new ArrayList<>();
        for (ContaEntity conta : listaContas) {
            if (conta.getClientId() == idCliente) {
                listaContasCliente.add(conta);
            }
        }

        if (listaContasCliente.get(0).equals(null)) {
            throw new Exception("Nao ha contas para esse cliente.");
        }

        for (ContaEntity conta : listaContasCliente) {
            if (conta.getId() == idConta) {
                Double saldo_anterior = conta.getSaldo();
                conta.setSaldo(conta.getSaldo() + contaDepositoEntrada.getValor());
                contaRepository.save(conta);

                ContaTransacaoEntity contaTransacaoEntity = new ContaTransacaoEntity();

                contaTransacaoEntity.setClientId(conta.getClientId());
                contaTransacaoEntity.setContaId(conta.getId());
                contaTransacaoEntity.setSaldo_anterior(saldo_anterior);
                contaTransacaoEntity.setValor_transacao(contaDepositoEntrada.getValor());
                contaTransacaoEntity.setSaldo_atual(conta.getSaldo());
                contaTransacaoEntity.setTipo("deposito");
                contaTransacaoRepository.save(contaTransacaoEntity);

                ContaSaida saida = ContaMapper.INSTANCE.mapToSaida(conta);

                return saida;
            }
        }

        return null;
    }

    public ContaSaida saque(Long idCliente, ContaSaqueEntrada contaSaqueEntrada, Long idConta) throws Exception {

        List<ContaEntity> listaContas = contaRepository.findAll();
        if (listaContas.isEmpty()) {
            throw new Exception("Nao ha contas cadastradas.");
        }

        List<ContaEntity> listaContasCliente = new ArrayList<>();
        for (ContaEntity conta : listaContas) {
            if (conta.getClientId() == idCliente) {
                listaContasCliente.add(conta);
            }
        }

        if (listaContasCliente.get(0).equals(null)) {
            throw new Exception("Nao ha contas para esse cliente.");
        }

        for (ContaEntity conta : listaContasCliente) {
            if (conta.getId() == idConta) {
                Double saldo_anterior = conta.getSaldo();
                conta.setSaldo(conta.getSaldo() - contaSaqueEntrada.getValor());
                contaRepository.save(conta);

                ContaTransacaoEntity contaTransacaoEntity = new ContaTransacaoEntity();

                contaTransacaoEntity.setClientId(conta.getClientId());
                contaTransacaoEntity.setContaId(conta.getId());
                contaTransacaoEntity.setSaldo_anterior(saldo_anterior);
                contaTransacaoEntity.setValor_transacao(contaSaqueEntrada.getValor());
                contaTransacaoEntity.setSaldo_atual(conta.getSaldo());
                contaTransacaoEntity.setTipo("saque");
                contaTransacaoRepository.save(contaTransacaoEntity);

                ContaSaida saida = ContaMapper.INSTANCE.mapToSaida(conta);

                return saida;
            }
        }

        return null;
    }

    public List<ContaTransacaoSaida> extrato(Long idCliente) throws Exception {

        List<ContaEntity> listaContas = contaRepository.findAll();
        if (listaContas.isEmpty()) {
            throw new Exception("Nao ha contas cadastradas.");
        }

        List<ContaEntity> listaContasDoCliente = new ArrayList<>();
        for (ContaEntity conta : listaContas) {
            if (conta.getClientId() == idCliente) {
                listaContasDoCliente.add(conta);
            }
        }

        if (listaContasDoCliente.isEmpty()) {
            throw new Exception("Nao ha contas para esse cliente.");
        }

        List<ContaTransacaoEntity> listaTransacoesEntity = contaTransacaoRepository.findAll();

        List<ContaTransacaoSaida> listaTransacoesSaida = new ArrayList<ContaTransacaoSaida>();

        for (ContaTransacaoEntity transacaoEntity : listaTransacoesEntity) {
            if (transacaoEntity.getClientId() == listaContasDoCliente.get(0).getClientId()) {
                listaTransacoesSaida.add(ContaMapper.INSTANCE.mapTransacaoToSaida(transacaoEntity));
            }
        }

        if (listaTransacoesSaida.isEmpty()) {
            return null;
        }

        return listaTransacoesSaida;
    }

}