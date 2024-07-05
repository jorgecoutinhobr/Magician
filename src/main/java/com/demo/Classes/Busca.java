package com.demo.Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Busca {
  private Busca(){}
  public static ArrayList<String> usuario(String email){
    final String PATH_USUARIOS = "src/main/java/com/demo/Database/usuarios.csv";
    ArrayList<String> resultado = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(PATH_USUARIOS))) {
      String linha;
      while ((linha = reader.readLine())!= null) {
        String[] campos = linha.split(",");
        if (campos.length >= 2 && campos[0].equals(email)) {
          resultado.addAll(Arrays.asList(campos));
          return resultado;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

}