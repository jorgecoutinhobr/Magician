package com.demo.Classes;
import java.util.ArrayList;

public class Usuario {
  private String email;
  private String senha;
  private String tipo;

  public Usuario(String email, String senha, String tipo){
    this.email = email;
    this.senha = senha;
    this.tipo = tipo;
  }

  public String getEmail(){
    return email;
  }


  public String getSenha(){
    return senha;
  }

  public String getTipo(){
    return tipo;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public static String autenticar(String email, String senha){
    ArrayList<String> dadosU = Busca.usuario(email);
    if(dadosU != null && dadosU.get(1).equals(senha)){
      String tipoU = dadosU.get(2);
      if(tipoU.equals("a")){
        // Supondo que a classe Aluno espera email, senha e tipo como parâmetros
        return dadosU.getLast();
      }else if(tipoU.equals("p")){
        // Supondo que a classe Professor espera email, senha e tipo como parâmetros
        return dadosU.getLast();
      }
    }
    return null;
  }
}