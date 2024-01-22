Sobre:
Criação de um sistema de gerenciamento de funcionarios de uma empresa pequena que permita cadastrar, buscar, atualizar e deletar um funcionário.

Caracteristicas:
Maven Project
Linguagem Java 17
Spring Boot 3.2.2

Dependencias utilizadas:
1 - Spring Web
2 - Spring Data JPA
3 - H2 Database
4 - Validation**

Informações:
Link de acesso ao banco: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb
User: banco
Password: 123456789
O arquivo "import.sql" foi utilizado para adicionar informações ao banco.

Classe "Employees" foi utilizada para a criação das entidades.
Classe "EmployeesRepository" foi utilizada acessar os dados do banco.
Classe "EmployeeController" foi utilizada para receber e responder as requisições.

1ª Etapa
Ok

2ª Etapa
Devido alguns problemas com a validação do "Not Null" optei por deixar as veriaveis idade e cep int e a variavel nome não ficou obrigatoria.

3ª Etapa
Ok

4ª Etapa
Ok, os testes estão disponiveis no arquivo "EMPLOYEES.postman_collection".

6ª Etapa
Ok, porém como optei por não fazer a 5ª Etapa ignorei a parte de consultar o endereço novamente.
