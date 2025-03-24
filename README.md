# Desafio - Sistema de gestão de contatos

## Índice

- [Descrição](#descrição)
- [Dependências](#dependências)
- [Como Rodar o Projeto](#como-rodar-o-projeto)
- [Testes](#testes)
- [Melhorias](#melhorias)

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

Crie um arquivo .env seguindo o exemplo do [`.env.example`](./.env.example).

### Banco de dados

caso queira usar o postgres local lembre de configurar as variaveis de ambiente e rode os dois arquivos Sql na pasta [`backend/src/main/resources/db`](./backend/src/main/resources/db/) no seu banco local

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

## Testes

No postman clique em importar e selecione o arquivo [`testes.postman_collection.json`](./testes.postman_collection.json) na raiz do repositório

## Melhorias

**Utilização de um framework**: A utilização de um framework como React ou Vue.js poderia melhorar a legibilidade e reusabilidade do código no frontend. Isso permitiria a criação de componentes reutilizáveis e uma melhor organização do código.

**Melhor visualização de dados**: Adicionar formatação automática para campos como CPF e telefone melhoraria a experiência do usuário.
