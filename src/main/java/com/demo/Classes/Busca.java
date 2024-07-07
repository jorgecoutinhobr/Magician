package com.demo.Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Busca {
  private Busca() {
  }

  public static ArrayList<String> usuario(String email) {
    final String PATH_USUARIOS = "src/main/java/com/demo/Database/usuarios.csv";
    ArrayList<String> resultado = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(PATH_USUARIOS))) {
      String linha;
      while ((linha = reader.readLine()) != null) {
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

  public static ArrayList<String> pergunta(String nivel, String email) {
    final String PATH_PERGUNTAS = "src/main/java/com/demo/Database/nivel" + nivel + ".csv";
    ArrayList<String> resultado = new ArrayList<>();
    try {

      ArrayList<String> performanceList = Busca.performance(email);

      String[] respondidas = performanceList.getLast().split(";");
      System.out.println(respondidas[0]);
      Set<String> perguntasRespondidas = new HashSet<>(Arrays.asList(respondidas));

      BufferedReader reader = new BufferedReader(new FileReader(PATH_PERGUNTAS));
      String linha;
      while ((linha = reader.readLine()) != null) {
        String[] campos = linha.split(";");
        String idPergunta = campos[campos.length - 1];

        if (!perguntasRespondidas.contains(idPergunta)) {
          int codigo = (int) (Math.random() * tamanhoArquivo(PATH_PERGUNTAS) + 1);
          if (Integer.parseInt(campos[campos.length - 1]) == codigo) {
            resultado.addAll(Arrays.asList(campos));
            return resultado;
          }
        }
      }
      if (resultado.size() == 0) {
        throw (new Exception("Não existem perguntas desse nível ou todas já foram respondidas."));
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return resultado;
  }

  public static int tamanhoArquivo(String PATH) {
    int tamanho = 0;
    try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
      String linha;
      while ((linha = reader.readLine()) != null) {
        tamanho++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return tamanho;
  }

  public static <e> ArrayList<String> performance(String email) {
    final String PATH_PERFORMANCE = "src/main/java/com/demo/Database/performance.csv";
    ArrayList<String> resultado = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(PATH_PERFORMANCE))) {
      String linha;
      while ((linha = reader.readLine()) != null) {
        String[] campos = linha.split(",");
        if (campos.length >= 2 && campos[0].equals(email)) {
          resultado.addAll(Arrays.asList(campos));
          return resultado;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    try (FileWriter writer = new FileWriter(PATH_PERFORMANCE, true)) {
      String[] r = {email, "0", "0", "[]"};
      resultado.addAll(Arrays.asList(r));
      writer.write(email + ",0,0,[]");
      return resultado;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

}