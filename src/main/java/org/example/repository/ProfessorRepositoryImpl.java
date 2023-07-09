package org.example.repository;

import org.example.database.FabricaConexao;
import org.example.model.Professor;

import java.sql.*;
import java.util.ArrayList;
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
        List<Professor> professores = new ArrayList<>();

        String sql = "SELECT * FROM professor";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Professor professor = new Professor();
                professor.setId(resultSet.getInt("id"));
                professor.setNome(resultSet.getString("nome"));
                professor.setDataNascimento(resultSet.getDate("data_nascimento").toLocalDate());
                professor.setCargaHorario(resultSet.getTime("carga_horario").toLocalTime());
                professor.setValorHora(resultSet.getDouble("valor_hora"));
                professor.setEstrangeiro(resultSet.getBoolean("estrangeiro"));
                professor.setHorasDisponiveis(resultSet.getInt("horas_disponiveis"));
                professor.setBiografia(resultSet.getString("biografia"));
                professor.setDataHoraCadastro(resultSet.getTimestamp("data_hora_cadastro").toLocalDateTime());

                professores.add(professor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return professores;
    }

    @Override
    public Boolean deletarProfessor(int id) {
        String sql = "DELETE FROM professor WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
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
