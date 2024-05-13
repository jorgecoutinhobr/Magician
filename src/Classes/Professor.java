package Classes;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Professor extends Usuario {
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
    Boolean usuario_existente = Usuario.existente(email);

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
    var introducao = pergunta.get(0);
    var questao = pergunta.get(1);
    var opcao1 = pergunta.get(2);
    var opcao2 = pergunta.get(3);
    var opcao3 = pergunta.get(4);
    var opcao4 = pergunta.get(5);
    var resposta = pergunta.get(6);

    try {
      FileWriter writer = new FileWriter(PATH_PERGUNTAS, true);
      writer.append(introducao);
      writer.append(",");
      writer.append(questao);
      writer.append(",");
      writer.append(opcao1);
      writer.append(",");
      writer.append(opcao2);
      writer.append(",");
      writer.append(opcao3);
      writer.append(",");
      writer.append(opcao4);
      writer.append(",");
      writer.append(resposta);
      writer.append("\n");
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}

