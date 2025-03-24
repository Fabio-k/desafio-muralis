# Desafio - Sistema de gestão de contatos

## Descrição

Este projeto foi desenvolvido como parte de um desafio técnico proposto pela empresa Muralis Tecnologia. O objetivo era criar um sistema de gestão de contatos com funcionalidades como criação, edição e visualização de clientes e seus contatos. Para isso, utilizei Spring Boot no backend e JavaScript no frontend, garantindo integração com um banco de dados PostgreSQL.

## Dependências

### Backend

- Java 21
- MapStruct
- Lombok
- Spring Boot 3.4.4
- PostgreSQL 17.4

### Frontend

- Node.js
- http-server

## Como Rodar o projeto

### Banco de dados

Rode os dois arquivos Sql na pasta `backend/src/main/resources/db` no seu postgres

Ou inicie o docker compose:

```bash
  docker compose up -d
```

### Backend
O backend está configurado para rodar na porta 8080

```bash
    cd backend
    mvn clean install
    mvn spring-boot:run
```

### Frontend
O Frontend está configurado para rodar na porta 3000

```bash
    cd frontend
    npm install
    npm run start
```

## Melhorias

**Utilização de um framework**: Achei que conseguiria manter uma boa legibilidade no front sem usar frameworks mas estava enganado a legibilidade do javascript usado nas páginas poderia estar componentizado se eu tivesse usado um framework o que teria dado uma melhor legibilidade e reusabilidade.

**Melhor visualização de dados**: Os dados como cpf e telefone não possuem formatação automática para que seja mais fácil do usuário ler os dados e inseri - los