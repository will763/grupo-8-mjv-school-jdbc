package org.example;

import org.example.database.Migration;
import org.example.model.Professor;
import org.example.repository.ProfessorRepositoryImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Migration.criarTabelaProfissao();

        Professor professor = new Professor();
        professor.setNome("Gleyson");
        professor.setDataNascimento(LocalDate.of(1990, 5, 15));
        professor.setCargaHorario(LocalTime.of(8, 0));
        professor.setValorHora(50.0);
        professor.setEstrangeiro(true);
        professor.setHorasDisponiveis(40);
        professor.setBiografia("Um professor com uma imensa paixão por ensinar.");
        professor.setDisciplinas(List.of("Geografia, Historia,Matematica"));
        professor.setDataHoraCadastro(LocalDateTime.now());

        ProfessorRepositoryImpl professorRepository = new ProfessorRepositoryImpl();

        //Integer professorId = professorRepository.criarProfessor(professor);
//
        professor.setId(1);
        professor.setDisciplinas(List.of("Ingles"));
        professor.setBiografia("nova biografia");
//
        professorRepository.atualizarProfessor(professor);


   //     professorRepository.deletarProfessor(1);

//          professorRepository.listarProfessores().forEach(x -> System.out.println(x.getNome()));
    }
}