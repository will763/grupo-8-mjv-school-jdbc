package org.example;

import org.example.database.Migration;
import org.example.model.Professor;
import org.example.repository.ProfessorRepositoryImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
        professor.setDataHoraCadastro(LocalDateTime.now());

        ProfessorRepositoryImpl professorRepository = new ProfessorRepositoryImpl();

//        Integer professorId = professorRepository.criarProfessor(professor);
//
//        professor.setId(professorId);
//        professor.setBiografia("kkkk");
//
//        professorRepository.atualizarProfessor(professor);


   //     professorRepository.deletarProfessor(1);

          professorRepository.listarProfessores().forEach(x -> System.out.println(x.getNome()));
    }
}