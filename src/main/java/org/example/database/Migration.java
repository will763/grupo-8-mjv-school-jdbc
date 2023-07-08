package org.example.database;

import java.sql.Connection;
import java.sql.SQLException;

public class Migration {

    public static void criarTabelaProfissao(){

        try {
            Connection conexao = FabricaConexao.conectar();

            String criarTabela = "CREATE TABLE IF NOT EXISTS professor (" +
                    "id SERIAL PRIMARY KEY, " +
                    "nome VARCHAR(100) NOT NULL, " +
                    "data_nascimento DATE, " +
                    "carga_horario TIME, " +
                    "valor_hora DOUBLE PRECISION, " +
                    "estrangeiro BOOLEAN, " +
                    "horas_disponiveis INT, " +
                    "biografia VARCHAR(500), " +
                    "data_hora_cadastro TIMESTAMP" +
                    ")";

            conexao.createStatement().execute(criarTabela);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
