package Classes;
import java.util.ArrayList;

public class Aluno extends Usuario {
  // melhorar esse metodo p/ fazer so uma chamada da funcao aluno
  public Aluno(String email) {
    super(busca_dados_aluno(email).get(0), busca_dados_aluno(email).get(1), busca_dados_aluno(email).get(2));
  }

  private static ArrayList<String> busca_dados_aluno(String email){
    ArrayList<String> usuario = Usuario.busca_usuario(email);
    return usuario;
  }

  // criar metodo para salvar historico de resposta

}