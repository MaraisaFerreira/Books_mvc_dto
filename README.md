# Book Management API

Esta é uma API REST para gerenciamento de livros desenvolvida com **Java** e **Spring Boot**. O projeto aplica padrões modernos como a separação de responsabilidades entre camadas e o uso de **DTOs** para entrada e saída de dados.

## 🚀 Tecnologias
* **Java 25**
* **Spring Boot 4**
* **Spring Data JPA**
* **Flyway migrations**
* **Spring Validation**

## 🛠️ Funcionalidades
A API permite realizar operações de CRUD e buscas personalizadas:

* **Listagem Total:** Retorna todos os livros cadastrados.
* **Busca por ID:** Localiza um exemplar específico.
* **Busca por Título:** Filtra livros via Request Body.
* **Busca por Título e Autor:** Localiza uma obra específica.
* **Cadastro:** Adiciona novos livros com validação de campos.
* **Atualização:** Atualiza dados de livros existentes.
* **Exclusão:** Remove registros por ID.

## 📑 Endpoints

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| **GET** | `/books/search_all` | Retorna todos os livros |
| **GET** | `/books/search_id/{id}` | Busca por ID |
| **POST** | `/books/search_title` | Busca por título |
| **POST** | `/books/search_title_and_author` | Busca por título e autor |
| **POST** | `/books/add_book` | Cadastra um novo livro |
| **PUT** | `/books/update_book` | Atualiza um livro |
| **DELETE** | `/books/delete_book/{id}` | Remove um livro |

## 🛡️ Tratamento de Erros
O projeto utiliza um **Global Exception Handler** para capturar exceções customizadas e erros de validação, retornando respostas padronizadas com os códigos HTTP corretos.
