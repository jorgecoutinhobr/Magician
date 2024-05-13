package Classes;
import java.io.FileWriter;
import java.io.IOException;

public class Professor extends Usuario {

  public Professor(String email, String senha, String tipo) {
    super(email, senha, tipo);
  }

  public void criaUsuario(String email, String senha, String tipo){
    salvaArquivo(email, senha, tipo);
  }

  // METODOS PRIVADOS
  private void salvaArquivo(String email, String senha, String tipo) {
    Usuario novoUsuario = new Usuario(email, senha, tipo);
    Boolean usuario_existente = Usuario.busca(email);


    if( usuario_existente == false ) {
      try {
        FileWriter writer = new FileWriter("src/Arquivos/usuarios.csv", true);
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

}

