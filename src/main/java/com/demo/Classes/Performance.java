package com.demo.Classes;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Performance {

  public static void addResposta(String email, boolean certa, String idpergunta) {
    ArrayList<String> performancelist = Busca.performance(email);
    String performaceAluno;
    performancelist.set(2, String.valueOf(Integer.parseInt(performancelist.get(2)) + 1));
    if (certa) performancelist.set(1, String.valueOf(Integer.parseInt(performancelist.get(1)) + 1));
    performaceAluno = performancelist.getFirst() +
            "," + performancelist.get(1) +
            "," + performancelist.get(2) +
            "," + performancelist.getLast().substring(0, performancelist.getLast().length() - 1) + ";" + idpergunta + "]";
    salvaPerformance(performaceAluno, performancelist.getFirst());
  }

  private static void salvaPerformance(String performancelist, String email) {
    final String PATH_PERFORMANCE = "src/main/java/com/demo/Database/performance.csv";
    ArrayList<String> linhas = new ArrayList<>();
    boolean encontrouEmail = false;

    try (BufferedReader reader = new BufferedReader(new FileReader(PATH_PERFORMANCE))) {
      String linha;
      while ((linha = reader.readLine()) != null) {
        String[] campos = linha.split(",");
        if (campos[0].equals(email)) {
          linhas.add(performancelist);
          encontrouEmail = true;
        } else {
          linhas.add(linha);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (encontrouEmail) {
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH_PERFORMANCE))) {
        for (String linhaAtualizada : linhas) {
          writer.write(linhaAtualizada);
          writer.newLine();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public static String showNivel(String email) {
    ArrayList<String> list = Busca.usuario(email);
    assert list != null;
    switch (list.get(3)) {
      case "2":
        return "Intermediário";
      case "3":
        return "Avançado";
      case "4":
        return "Fluente";
      case "1":
        return "Iniciante";
      default:
        return null;
    }
  }
}
