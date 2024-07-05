package com.demo.Classes;

import java.util.ArrayList;

public class Aluno extends Usuario {
  // melhorar esse metodo p/ fazer so uma chamada da funcao aluno
  private static final String PATH_HISTORICOPERGUNTAS = "src/Arquivos/historico_de_perguntas.csv";
  private int nivel;
  public Aluno(String email, String senha, String tipo) {
    super(email, senha, tipo);
  }

  private static ArrayList<String> busca_dados_aluno(String email){
    return Busca.usuario(email);
  }

}