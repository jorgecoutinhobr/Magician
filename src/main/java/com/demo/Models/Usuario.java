package com.demo.Models;

import java.io.*;
import java.util.ArrayList;

public class Usuario {
  private static final String PATH_USUARIOS = "src/main/java/com/demo/Database/usuarios.csv";

  public static String[] autentica(String email, String senha) {
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

  public static void adiciona(String usuario) {
    try (FileWriter fw = new FileWriter(PATH_USUARIOS, true);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter out = new PrintWriter(bw)) {
      out.print(usuario);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void altera(ArrayList<String> usuarios) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH_USUARIOS))) {
      for (String linhaAtualizada : usuarios) {
        writer.write(linhaAtualizada);
        writer.newLine();
      }
    }
    catch (Exception e){
      e.printStackTrace();
    }
  }

  public static ArrayList<String> retornaArquivo(ArrayList<String> usuarios, String anivel){
    ArrayList<String> linhas = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/com/demo/Database/usuarios.csv"))) {
      String uemail = usuarios.getFirst();
      String usenha = usuarios.get(1);
      String unome = usuarios.get(2);
      String linha;
      System.out.println("\n" +uemail + usenha + unome + anivel);
      while ((linha = reader.readLine()) != null) {
        String[] campos = linha.split(",");
        if (campos[0].equals(usuarios.getFirst())) {
          if (anivel == "0") {
          } else if (anivel != "")
            linhas.add(uemail +
                    "," +
                    usenha +
                    "," +
                    unome +
                    "," +
                    anivel +
                    ",a"
            );
          else linhas.add(uemail +
                    "," +
                    usenha +
                    "," +
                    unome +
                    "," +
                    "p"
            );
        } else {
          linhas.add(linha);
        }
      }
      return linhas;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return linhas;
  }
}