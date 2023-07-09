# mjv-school-jdbc

![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Java](https://img.shields.io/badge/Java-17-orange.svg)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15.3-blue.svg)
![Maven](https://img.shields.io/badge/Maven-3.6.3-blue.svg)

> ✏️ Projeto de exemplo para demonstrar como utilizar JDBC e o banco de dados PostgreSQL para criar, listar, atualizar e excluir registros em uma tabela de professores.

Este projeto foi desenvolvido utilizando Java puro com o auxílio do driver JDBC do PostgreSQL. Ele oferece uma funcionalidade básica de gerenciamento de professores, permitindo criar novos registros, listar todos os registros existentes, atualizar informações de um professor e excluir um professor do banco de dados.

## Pré-requisitos

Antes de executar este projeto, certifique-se de ter o seguinte instalado em sua máquina:

- ✅ Java Development Kit (JDK) 17 ou superior
- ✅ PostgreSQL (versão compatível com o driver JDBC 42.6.0)
- ✅ Maven

## Configuração do Banco de Dados

1. Crie um banco de dados no PostgreSQL para este projeto.
2. 📝 Atualize as informações de conexão com o banco de dados no arquivo `FabricaConexao`.

## Executando o Projeto

Siga as etapas abaixo para executar o projeto:

1. Clone este repositório em sua máquina local.
2. Navegue até o diretório raiz do projeto.
3. 🚀 Compile o projeto usando o comando `mvn clean package`.
4. 💻 Execute o projeto usando o comando `java -jar target/mjv-school-jdbc.jar`.

## Funcionalidades

Este projeto oferece as seguintes funcionalidades:

- ➕ Criar um novo professor no banco de dados.
- 📚 Listar todos os professores cadastrados.
- ✏️ Atualizar as informações de um professor existente.
- 🗑️ Excluir um professor do banco de dados.

## Contribuindo

Se você deseja contribuir, siga as etapas abaixo:

1. Fork este repositório.
2. Crie um branch para a sua contribuição.
3. Faça as alterações desejadas.
4. Faça commit das suas alterações.
5. Envie as alterações para o seu fork.
6. Abra um Pull Request neste repositório.
