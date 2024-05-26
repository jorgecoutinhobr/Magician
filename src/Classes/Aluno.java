import Classes.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Aluno extends Usuario {
  // melhorar esse metodo p/ fazer so uma chamada da funcao aluno
  private int nivel;
  public Aluno(String email) {
    super(busca_dados_aluno(email).get(0), busca_dados_aluno(email).get(1), busca_dados_aluno(email).get(2));
  }

  private static ArrayList<String> busca_dados_aluno(String email){
    ArrayList<String> usuario = BuscaUsuario.busca(email,0);
    return usuario;
  }

  // criar metodo para salvar historico de resposta

}

public static ArrayList<String> BuscaPergunta2(int nivel){
  final String PATH_PERGUNTAS = "src/Arquivos/nivel" + String.valueOf(nivel) +  ".csv";
  ArrayList<String> resultado = new ArrayList<>();
  try (BufferedReader reader = new BufferedReader(new FileReader(PATH_PERGUNTAS))) {
    String linha;
    int codigo = (int) (Math.random() * 8);
    while ((linha = reader.readLine())!= null) {
      String[] campos = linha.split(";");
      if (Integer.parseInt(campos[campos.length-1]) == codigo) {
        resultado.addAll(Arrays.asList(campos));
        return resultado;
      }
    }
  } catch (IOException e) {
    e.printStackTrace();
  }
  return resultado;
}

public void main() {
}