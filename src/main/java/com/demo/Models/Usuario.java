package com.demo.Models;

import java.util.ArrayList;

public class Usuario {

  public static String[] autenticar(String email, String senha) {
    ArrayList<String> dadosU = Busca.usuario(email);
    if (dadosU != null && dadosU.get(1).equals(senha)) {
      String tipoU = dadosU.getLast();
      if (tipoU.equals("a")) {
        return new String[]{dadosU.get(3), dadosU.getLast()};
      } else if (tipoU.equals("p")) {
        return new String[]{null, dadosU.getLast()};
      }
    }
    return null;
  }
}