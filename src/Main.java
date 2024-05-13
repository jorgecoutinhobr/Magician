import Classes.Usuario;
import Classes.Professor;

public class Main {
  public static void main(String[] args) {
    Professor p = new Professor("professor@example.com", "senha123", "professor");

    p.criaUsuario("a1@com", "123", "aluno");
  }
}