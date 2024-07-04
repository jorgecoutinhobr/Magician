package Classes;

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

  public void perguntaFormatada(ArrayList<String> perguntas){
    if(perguntas.size() > 0) {
      System.out.println("\n\n" + perguntas.get(0) + "\n\n" + perguntas.get(1) + "\n");
      for (int i = 2; i < (perguntas.size() - 2); i++) {
        System.out.println(perguntas.get(i));
      }
    }
  }

}
