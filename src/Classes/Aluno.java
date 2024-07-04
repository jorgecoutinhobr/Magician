package Classes;
import java.util.ArrayList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Aluno extends Usuario {
  // melhorar esse metodo p/ fazer so uma chamada da funcao aluno
  private static final String PATH_HISTORICOPERGUNTAS = "src/Arquivos/historico_de_perguntas.csv";
  private int nivel;
  public Aluno(String email) {
    super(busca_dados_aluno(email).get(0), busca_dados_aluno(email).get(1), busca_dados_aluno(email).get(2));
  }

  private static ArrayList<String> busca_dados_aluno(String email){
    return BuscaUsuario.busca(email);
  }

  // criar metodo para salvar historico de resposta
  public void salvarHistorico(){

  }

}