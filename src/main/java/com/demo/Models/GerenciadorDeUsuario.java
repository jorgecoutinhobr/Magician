package com.demo.Models;

public class GerenciadorDeUsuario {
  private static GerenciadorDeUsuario instancia;
  private Professor professorLogado;
  private Aluno alunoLogado;

  private GerenciadorDeUsuario() {
  }

  public static GerenciadorDeUsuario getInstancia() {
    if (instancia == null) {
      instancia = new GerenciadorDeUsuario();
    }
    return instancia;
  }

  public void setProfessorLogado(Professor professor) {
    this.professorLogado = professor;
  }

  public Professor getProfessorLogado() {
    return professorLogado;
  }

  public void setAlunoLogado(Aluno aluno) {
    this.alunoLogado = aluno;
  }

  public Aluno getAlunoLogado() {
    return alunoLogado;
  }
}