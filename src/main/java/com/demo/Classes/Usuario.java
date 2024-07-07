package com.demo.Classes;
import java.util.ArrayList;

public class Usuario {

  public static String[] autenticar(String email, String senha){
    ArrayList<String> dadosU = Busca.usuario(email);
    if(dadosU != null && dadosU.get(1).equals(senha)){
      String tipoU = dadosU.getLast();
      if(tipoU.equals("a")){
        // Supondo que a classe Aluno espera email, senha e tipo como parâmetros
        return new String[]{dadosU.get(3),dadosU.getLast()};
      }else if(tipoU.equals("p")){
        // Supondo que a classe Professor espera email, senha e tipo como parâmetros
        return new String[]{null,dadosU.getLast()};
      }
    }
    return null;
  }
}