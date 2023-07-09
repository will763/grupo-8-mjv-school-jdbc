package org.example.repository;

import org.example.database.FabricaConexao;
import org.example.model.Professor;

import java.sql.*;
import java.util.List;

public class ProfessorRepositoryImpl implements ProfessorRepository{
    private Connection connection;

    public ProfessorRepositoryImpl() {
        this.connection = FabricaConexao.conectar();
    }

    @Override
    public int criarProfessor(Professor professor) {
        try {
            String sql = """
                    INSERT INTO professor
                    (nome,
                    data_nascimento,
                    valor_hora,
                    estrangeiro,
                    horas_disponiveis,
                    biografia,
                    data_hora_cadastro,
                    carga_horario)
                    VALUES
                    (?, ?, ?, ?, ?, ?, ?, ? )                    
                    """;

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, professor.getNome());
            statement.setDate(2, Date.valueOf(professor.getDataNascimento()));
            statement.setDouble(3, professor.getValorHora());
            statement.setBoolean(4, professor.isEstrangeiro() );
            statement.setInt(5, professor.getHorasDisponiveis());
            statement.setString(6, professor.getBiografia());
            statement.setTimestamp(7, Timestamp.valueOf(professor.getDataHoraCadastro()));
            statement.setTime(8, Time.valueOf(professor.getCargaHorario()));

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {

                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return -1;
    }

    @Override
    public List<Professor> listarProfessores() {
        // criar essse metodo colocar a expressao entre try catch

        return null;
    }

    @Override
    public Professor deletarProfessor(int id) {
        // criar essse metodo colocar a expressao entre try catch
        return null;
    }

    @Override
    public void atualizarProfessor(Professor professor) {
        try {
            String sql = """
                        UPDATE professor SET
                        nome = ? ,
                        data_nascimento = ? ,
                        valor_hora = ? ,
                        estrangeiro = ? ,
                        horas_disponiveis = ? ,
                        biografia = ? ,
                        data_hora_cadastro = ? ,
                        carga_horario = ? 
                        WHERE id = ?                   
                        """;

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, professor.getNome());
            statement.setDate(2, Date.valueOf(professor.getDataNascimento()));
            statement.setDouble(3, professor.getValorHora());
            statement.setBoolean(4, professor.isEstrangeiro() );
            statement.setInt(5, professor.getHorasDisponiveis());
            statement.setString(6, professor.getBiografia());
            statement.setTimestamp(7, Timestamp.valueOf(professor.getDataHoraCadastro()));
            statement.setTime(8, Time.valueOf(professor.getCargaHorario()));
            statement.setInt(9, professor.getId());

            statement.executeUpdate();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
