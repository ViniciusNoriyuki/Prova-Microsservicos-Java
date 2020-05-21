# ProvaMicroServico
Prova utilizando conceito de microservicos em Java.

**Realizar saque - PUT** 
```
localhost:8086/iti/gateway/clientes/contas/{idCliente}/{idConta}/saque

{
  "valor": Double valor
}
```
**Realizar deposito - PUT** 
```
localhost:8086/iti/gateway/clientes/contas/{idCliente}/{idConta}/deposito

{
  "valor": Double valor
}
```
**Mostrar extrato do cliente - GET** 
```
localhost:8086/iti/gateway/clientes/contas/{idCliente}/extrato
```
**Salvar cliente e contas - POST** 
```
localhost:8086/iti/gateway/clientes/contas/salvarClienteESuasContas

{
    "cliente": {
        "nome": Double nome
    },
    "contas": [
        {
            "tipo": String tipo
            "agencia": Integer agencia
            "conta": Integer conta,
            "clientId": Long clientId ou null
        }
    ]
}
```
**Obter todos os cliente e contas - POST** 
```
localhost:8086/iti/gateway/clientes/contas/obterTodosClientesESuasContas

```
