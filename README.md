# CurrencyNow API

API REST que fornece taxas de câmbio e conversão de moedas em tempo real.

Construí este projeto como parte do meu portfólio de back-end, com foco em criar uma API Java bem estruturada usando Spring Boot. 

Com o principal objetivo de demonstrar o consumo de serviços externos (APIs de terceiros) e o gerenciamento seguro de chaves de API.

Os dados de câmbio são obtidos ao vivo da [ExchangeRate-API](https://www.exchangerate-api.com/).

---

## Stack 

* **Java 17**
* **Spring Boot**
* **Maven**
* **Spring Web**
* **RestTemplate**
* **Jackson**
* **Lombok**

---

## Como Rodar o Projeto

### 1. Pré-requisitos

* JDK 17 (ou superior)
* Maven
* Uma chave de API gratuita da [ExchangeRate-API](https://www.exchangerate-api.com/).

### 2. Clonar o Repositório

```bash
git clone [https://github.com/ErickDev00/FXConverter.git](https://github.com/ErickDev00/FXConverter.git)
cd currencynow
```

### 3. Configurar a Chave de API

Para proteger a chave de API, o projeto lê a chave me uma variável de ambiente.

**Como configurar no IntelliJ IDEA (Community ou Ultimate):**
1.  Obtenha sua chave no site da ExchangeRate-API.
2.  No IntelliJ, vá em `Run` > `Edit Configurations...`.
3.  No painel esquerdo, selecione `FxconverterApiApplication` (ou o nome da sua classe principal, na categoria "Application").
4.  No painel direito, clique em `Modify options` e marque a caixa `Environment variables`.
5.  Um novo campo aparecerá. Adicione:
    * **Name:** `API_KEY`
    * **Value:** `12345678` (cole sua chave aqui)
6.  Clique em `Apply` e `OK`.


### 4. Executar

Você pode iniciar a aplicação diretamente pela sua IDE (clicando "Play") ou usando o Maven no terminal:

```bash
mvn spring-boot:run
```

---
## Documentação

### `GET /api/convert`

Converte um valor entre duas moedas.

**Query Parameters:**

| Parâmetro | Tipo     | Obrigatório | Exemplo | Descrição                   |
|:----------|:---------|:------------|:--------|:----------------------------|
| `from`    | `String` | Sim         | `USD`   | Código da moeda de origem.  |
| `to`      | `String` | Sim         | `BRL`   | Código da moeda de destino. |
| `amount`  | `double` | Sim         | `150`   | Valor a ser convertido.     |


**Exemplo de Requisição:**
```http
GET http://localhost:8080/api/convert?from=USD&to=BRL&amount=150
```

**Exemplo de Resposta(200 OK):**

```
{
"fromCurrency": "USD",
"toCurrency": "BRL",
"originalAmount": 150.0,
"convertedAmount": 774.195,
"rate": 5.1613
}
```




