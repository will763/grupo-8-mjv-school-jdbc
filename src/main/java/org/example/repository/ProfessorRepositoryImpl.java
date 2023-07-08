package org.example.repository;

import org.example.database.FabricaConexao;
import org.example.model.Professor;

import java.sql.Connection;
import java.util.List;

public class ProfessorRepositoryImpl implements ProfessorRepository{
    private Connection connection;

    public ProfessorRepositoryImpl() {
        this.connection = FabricaConexao.conectar();
    }

    @Override
    public void criarProfessor(Professor professor) {
    // criar essse metodo colocar a expressao entre try catch
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
        // criar essse metodo colocar a expressao entre try catch
    }
}
