package com.demo.Classes;

import java.util.ArrayList;

public class Aluno {
  // melhorar esse metodo p/ fazer so uma chamada da funcao aluno
  private int nivel;
  private String email;
  private String senha;

  public Aluno(String email, String senha) {
    this.email = email;
    this.senha = senha;
  }
/*  private static ArrayList<String> busca_dados_aluno(String email){
    return Busca.usuario(email);
  }
*/

  public String getEmail() {
    return email;
  }

  public String getSenha(){
    return senha;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }
}