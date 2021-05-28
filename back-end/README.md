# Desafio @ Justa Back-end

Projeto de uma API Rest com o objetivo de cadastrar usuários e criar uma watchlist de criptomoedas personalizada para acompanhar em tempo real as informações das criptos, consumindo a API do CoinCap para obter os dados. 

A API também consome a API do ViaCep para o preenchimento automático de campos do endereço do usuário

# Tecnologias utilizadas:
- Spring Data + JPA para conexão com o banco de dados e construção das entidades
- Spring Cloud Open Feign para o consumo das APIs
- Spring Fox Swagger para a criação do Swagger
- Spring Security + JWT para autenticação e autorização de usuários
- Banco H2 para testes
- Banco PostgreSQL
- JavaDoc

Os endpoints precisam de autenticação via bearer (token que pode ser obtido através dos headers), exceto o endpoint de cadastro. 

