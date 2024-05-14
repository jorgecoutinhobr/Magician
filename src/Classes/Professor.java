package Classes;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class  Professor extends Usuario {
  private static final String PATH_USUARIOS = "src/Arquivos/usuarios.csv";
  private static final String PATH_PERGUNTAS = "src/Arquivos/perguntas.csv";

  public Professor(String email, String senha, String tipo) {
    super(email, senha, tipo);
  }

  public void criaUsuario(String email, String senha, String tipo){
    salvaUsuario(email, senha, tipo);
  }

  public void criaPergunta(ArrayList<String> pergunta){
    salvaPergunta(pergunta);
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

  private void salvaPergunta(ArrayList<String> pergunta){
    try {
      FileWriter writer = new FileWriter(PATH_PERGUNTAS, true);
      for(int i = 0; i < pergunta.size()-1; i++){
        writer.append(pergunta.get(i));
        writer.append(";");
      }
      writer.append(pergunta.get(pergunta.size()-1));
      writer.append("\n");
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}

