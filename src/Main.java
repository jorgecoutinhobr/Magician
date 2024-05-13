import Classes.Professor;
import Classes.Usuario;
import Classes.Aluno;
import Classes.BuscaUsuario;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
  public static void main(String[] args) {
   Professor p = new Professor("professor@example.com", "senha123", "professor");
   p.criaUsuario("a4@com", "123", "aluno");
   // p.criaUsuario("p@com", "123", "professor");
   p.criaPergunta(new ArrayList<>(Arrays.asList("Question 1", "What's the answer?", "a", "b", "c", "d", "b", "0")));

    var x = BuscaUsuario.existente("p@com");
   // var x = new Aluno("a2@com");
   System.out.println(x);
   // System.out.println(x.getSenha());
  }
}