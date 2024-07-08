package com.demo.Support;

import com.demo.Models.Aluno;
import com.demo.Models.Professor;

public class SingletonUsuario {
  private static SingletonUsuario instancia;
  private Professor professorLogado;
  private Aluno alunoLogado;

  private SingletonUsuario() {
  }

  public static SingletonUsuario getInstancia() {
    if (instancia == null) {
      instancia = new SingletonUsuario();
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