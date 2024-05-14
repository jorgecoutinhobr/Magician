import Classes.*;

import java.util.ArrayList;
import java.util.Arrays;


public class Main {
  public static void main(String[] args) {
   Professor p = new Professor("professor@example.com", "senha123", "professor");
   p.criaUsuario("a1@com", "123", "aluno");
   p.criaUsuario("p@com", "123", "professor");
   p.criaPergunta(new ArrayList<>(Arrays.asList("Text 1", "Question 1", "a", "b", "c", "d", "b", "1")));

    //var x = BuscaUsuario.existente("p@com");
   var x = new Aluno("a2@com");
   System.out.println(x.getEmail());
   //BuscaPergunta.perguntaFormatada(BuscaPergunta.busca(1));

  }
}