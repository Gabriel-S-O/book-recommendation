# book-recommedation

Esta é uma simples aplicação para gestão de biblioteca que
permite o cadastro de usuários, livros e empréstimos.

### Requisitos

Para executar o projeto, é necessário ter:

* IDE com suporte ao java com spring (Intellij, VSCode)
* [JDK 21 Do Java ](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
* [Maven](https://maven.apache.org/download.cgi)

Para executar o projeto só precisa executa-lo pela `IDE` ou rodar o comando `mvn spring-boot:run`

#### Não é necessário configurar um banco de dados pois está sendo utilizado o banco em memória H2, toda vez que o projeto é executado banco é apagado e recriado pelas migrations do flyway.

