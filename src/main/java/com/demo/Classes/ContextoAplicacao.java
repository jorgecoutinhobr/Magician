package com.demo.Classes;

public class ContextoAplicacao {
  private static ContextoAplicacao instancia;
  private Professor professorLogado;
  private Aluno alunoLogado;

  private ContextoAplicacao() {
  }

  public static ContextoAplicacao getInstancia() {
    if (instancia == null) {
      instancia = new ContextoAplicacao();
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