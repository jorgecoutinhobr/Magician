import Classes.*;

import java.util.ArrayList;
import java.util.Arrays;


public class Main {
  public static void main(String[] args) {
   Professor p = new Professor("professor@example.com", "senha123", "professor");
   p.criaUsuario("a1@com", "123", "aluno");
   p.criaUsuario("salve@com", "123", "professor");
   //p.criaPergunta(new ArrayList<>(Arrays.asList("Text 2", "Question 1", "a", "b", "c", "d", "b")),1);

    //var x = BuscaUsuario.existente("p@com");
   var x = new Aluno("a1@com");
   System.out.println(x.getEmail());
   x.perguntaFormatada(Busca.pergunta(1));
   //BuscaPergunta.perguntaFormatada(BuscaPergunta.busca(1));
  }
}