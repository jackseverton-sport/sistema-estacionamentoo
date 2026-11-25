# Sistema de Gerenciamento de Estacionamento

## Sobre o projeto

Sistema de gerenciamento de estacionamento desenvolvido em Java com Spring Boot, com o objetivo de controlar veículos, vagas e registros de entrada e saída, incluindo o cálculo do valor a pagar pelo período de permanência.

## Tecnologias utilizadas

- Java 21
- Spring Boot 4.2.0
- Maven
- Spring Data JPA
- Hibernate
- Banco de dados H2
- Jakarta Validation
- API REST

## Funcionalidades

- Cadastro de veículos.
- Consulta de veículos cadastrados.
- Busca de veículos por ID.
- Exclusão de veículos.
- Validação de dados dos veículos.
- Impedimento de cadastro de placas duplicadas.
- Cadastro e consulta de vagas.
- Controle de vagas ocupadas e disponíveis.
- Registro de entrada de veículos.
- Registro de saída de veículos.
- Cálculo automático do valor do estacionamento.

## Regras de cobrança

O sistema utiliza as seguintes regras:

- Primeira hora: R$ 10,00.
- Cada hora adicional ou fração: R$ 2,50.

## Endpoints da API

### Veículos

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/veiculos` | Cadastrar veículo |
| GET | `/veiculos` | Listar veículos |
| GET | `/veiculos/{id}` | Buscar veículo por ID |
| DELETE | `/veiculos/{id}` | Excluir veículo |

### Vagas

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/vagas` | Cadastrar vaga |
| GET | `/vagas` | Listar vagas |
| GET | `/vagas/{id}` | Buscar vaga por ID |
| DELETE | `/vagas/{id}` | Excluir vaga |

### Registros de estacionamento

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/registros` | Cadastrar registro |
| GET | `/registros` | Listar registros |
| GET | `/registros/{id}` | Buscar registro por ID |
| POST | `/registros/entrada` | Registrar entrada |
| PUT | `/registros/{id}/saida` | Registrar saída |

## Como executar o projeto

### Pré-requisitos

- Java 21 instalado.
- Git instalado.
- IntelliJ IDEA ou outra IDE compatível com Java.

### Clonar o repositório

```bash
git clone https://github.com/jackseverton-sport/sistema-estacionamentoo.git
```

### Entrar na pasta

```bash
cd sistema-estacionamentoo
```

### Executar a aplicação

No Windows, utilizando o Maven Wrapper:

```bash
mvnw.cmd spring-boot:run
```

A aplicação estará disponível em:

```text
http://localhost:8080
```

## Banco de dados

O projeto utiliza o banco de dados H2 em memória, com persistência durante a execução da aplicação. Os dados são reiniciados quando a aplicação é encerrada.

## Testes da API

Os endpoints podem ser testados utilizando o Postman, enviando requisições HTTP com os métodos GET, POST, PUT e DELETE.

## Autor

Projeto desenvolvido para fins de aprendizado e prática de desenvolvimento backend com Java e Spring Boot.
