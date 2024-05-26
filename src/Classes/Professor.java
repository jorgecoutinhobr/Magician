package Classes;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class  Professor extends Usuario {
  private static final String PATH_USUARIOS = "src/Arquivos/usuarios.csv";
  //private static final String PATH_PERGUNTAS = "src/Arquivos/perguntas.csv";

  public Professor(String email, String senha, String tipo) {
    super(email, senha, tipo);
  }

  public void criaUsuario(String email, String senha, String tipo){
    salvaUsuario(email, senha, tipo);
  }

  public void criaPergunta(ArrayList<String> pergunta, int nivel){
    salvaPergunta(pergunta, nivel);
  }

  // METODOS PRIVADOS
  private void salvaUsuario(String email, String senha, String tipo) {
    Usuario novoUsuario = new Usuario(email, senha, tipo);
    Boolean usuario_existente = BuscaUsuario.existente(novoUsuario.getEmail());

    if( usuario_existente == false ) {
      try {
        FileWriter writer = new FileWriter(PATH_USUARIOS, true);
        writer.append(novoUsuario.getEmail());
        writer.append(",");
        writer.append(novoUsuario.getSenha());
        writer.append(",");
        writer.append(novoUsuario.getTipo());
        writer.append("\n");
        writer.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      System.out.println("Usuario ja existente");
    }
  }

  private void salvaPergunta(ArrayList<String> pergunta, int nivel){
    final String PATH_PERGUNTAS = "src/Arquivos/nivel" + String.valueOf(nivel) +  ".csv";
    Boolean pergunta_existente = existente(pergunta, PATH_PERGUNTAS);
    if (pergunta_existente == false) {
      try {
        FileWriter writer = new FileWriter(PATH_PERGUNTAS, true);
        for (int i = 0; i < pergunta.size(); i++) {
          writer.append(pergunta.get(i));
          writer.append(";");
        }
        int i = 1;
        BufferedReader reader = new BufferedReader(new FileReader(PATH_PERGUNTAS));
        while(reader.lines().iterator().hasNext()){
          i++;
        }
        writer.append(Integer.toString(i));
        writer.append("\n");
        writer.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      System.out.println("Pergunta ja existe no Db");
    }
  }

  public static Boolean existente(ArrayList<String> pergunta, String path){
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
      String linha;
      while ((linha = reader.readLine())!= null) {
        String[] campos = linha.split(";");
        if (campos[0].equals(pergunta.getFirst()) && campos[1].equals(pergunta.get(1))) {
          return true;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }
}
