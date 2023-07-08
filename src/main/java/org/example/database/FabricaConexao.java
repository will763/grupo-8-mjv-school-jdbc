package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
    private static Connection conexao;

    public static Connection conectar(){

        if (conexao == null){
            try {
                Connection conexao = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/postgres",
                        "postgres",
                        "1234"
                );

                return conexao;
            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else {
            return conexao;
        }

    }

}
