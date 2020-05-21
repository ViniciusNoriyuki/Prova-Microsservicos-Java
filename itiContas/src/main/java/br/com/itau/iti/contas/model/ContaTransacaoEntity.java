package br.com.itau.iti.contas.model;

import javax.persistence.*;

@Entity(name = "ContaTransacao")
public class ContaTransacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "clientId")
    Long clientId;

    @Column(name = "contaId")
    Long contaId;

    @Column(name = "saldo_anterior")
    Double saldo_anterior;

    @Column(name = "valor_transacao")
    Double valor_transacao;

    @Column(name = "saldo_atual")
    Double saldo_atual;

    @Column(name = "tipo")
    String tipo;

    public Double getValor_transacao() {
        return valor_transacao;
    }

    public void setValor_transacao(Double valor_transacao) {
        this.valor_transacao = valor_transacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getContaId() {
        return contaId;
    }

    public void setContaId(Long contaId) {
        this.contaId = contaId;
    }

    public Double getSaldo_anterior() {
        return saldo_anterior;
    }

    public void setSaldo_anterior(Double saldo_anterior) {
        this.saldo_anterior = saldo_anterior;
    }

    public Double getSaldo_atual() {
        return saldo_atual;
    }

    public void setSaldo_atual(Double saldo_atual) {
        this.saldo_atual = saldo_atual;
    }

}
