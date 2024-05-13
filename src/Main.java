import Classes.Professor;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
  public static void main(String[] args) {
    Professor p = new Professor("professor@example.com", "senha123", "professor");

    p.criaUsuario("a2@com", "123", "aluno");
    p.criaPergunta(new ArrayList<>(Arrays.asList("Question 1", "What's the answer?", "a", "b", "c", "d", "b")));
  }
}