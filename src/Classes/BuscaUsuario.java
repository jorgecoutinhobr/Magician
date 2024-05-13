package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class BuscaUsuario {
  private static final String PATH_USUARIOS = "src/Arquivos/usuarios.csv";

  public static boolean existente(String email) {
    try (BufferedReader reader = new BufferedReader(new FileReader(PATH_USUARIOS))) {
      String linha;
      while ((linha = reader.readLine())!= null) {
        String[] campos = linha.split(",");
        if (campos.length >= 2 && campos[0].equals(email)) {
          return true;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }

  public static ArrayList<String> busca(String email){
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
    return resultado;
  }
}
