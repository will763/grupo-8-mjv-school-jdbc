package org.example.repository;

import org.example.model.Professor;

import java.util.List;

public interface ProfessorRepository {
    int criarProfessor(Professor professor);
    List<Professor> listarProfessores();
    Professor deletarProfessor(int id);
    void atualizarProfessor(Professor professor);
}
