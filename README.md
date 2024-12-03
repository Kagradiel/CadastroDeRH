# RHSys - Sistema de Cadastro RH

## Introdução

O sistema de cadastro de recursos humanos (RHSys) foi desenvolvido como projeto em grupo no Projeto Integrador da Generation.<br>
O RHSys tem como objetivo gerenciar as informações de funcionários de uma empresa, facilitando processos como cadastro, atualização e consulta de dados.<br><br>


## UML - Diagrama de Classes

<br><br>


## Funcionalidades

-Cadastro de funcionários, incluindo informações pessoais e profissionais. <br>
-Consulta de funcionários por diversos critérios (Nome, CPF, Cargo). <br>
-Atualização dos dados de cadastro. <br>
-Exclusão de registros de funcionários. <br>
-Geração de relatórios personalizados. <br><br>


## Tecnologias Utilizadas

-Java 17 <br>
-Spring Boot API REST <br>
-Spring Web <br>
-Spring Boot Dev Tools <br>
-Validation <br>
-Spring Data JPA <br>
-MySQL Driver <br>
-Swagger - Disponível em: [http://localhost:8080/swagger-ui/index.html] <br><br>


## Estrutura do Projeto

-Model: Contém as classes que representam o sistema (Pessoa, Cargo). <br>
-Repository: Gerencia os dados da aplicação, permitindo criar, ler, atualizar e excluir registros (JpaRepository). <br>
-Controller: Implementa as regras de negócio e mapeia os endpoints REST (GET, POST, PUT, DELETE). <br>
-DTO (Data Transfer Object): Usado para limitar o acesso direto às entidades do modelo, protegendo e organizando os dados transferidos. <br><br>


## Testes
-Execução dos Testes: Utilizando Insomnia.<br>
-Cobertura de Testes: Foram testadas as requisições get, post, put e delete. <br>
