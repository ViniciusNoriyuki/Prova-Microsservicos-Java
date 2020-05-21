package br.com.itau.iti.gateway.conta.model;

public class ContaTransacaoSaida {
    Long id;
    Long clientId;
    Long contaId;
    Double saldo_anterior;
    Double valor_transacao;
    Double saldo_atual;
    String tipo;

    public Double getValor_transacao() {
        return valor_transacao;
    }

    public void setValor_transacao(Double valor_transacao) {
        this.valor_transacao = valor_transacao;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
