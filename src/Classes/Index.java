package Classes;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Index {
    private Scanner scanner;

    public Index(){
        scanner = new Scanner(System.in);
    }

    //autenticação do usuario. usado em fazerLogin()
    private Usuario autenticar(String email, String senha){
        ArrayList<String> dadosU = Busca.usuario(email);
        if(dadosU.size() > 0 && dadosU.get(1).equals(senha)){
            String tipoU = dadosU.get(2);
            if(tipoU.equals("aluno")){
                return new Aluno(email);
            }else if(tipoU.equals("professor")){
                return new Professor(email, senha, tipoU);
            }
        }
        return null;
    }

  //scanneia dados, os autentica e direciona pra página do tipo de usuario. usado em init()
    private void fazerLogin(){
        //esse carai ta exibindo os dois ao mesmo tempo sla pq
        System.out.print("Insira seu email: ");
        String email = scanner.nextLine();
        System.out.print("Insira sua senha: ");
        String senha = scanner.nextLine();

        Usuario u = autenticar(email, senha);
        if(u != null){
            System.out.println("\nBem vindo!");
            if(u instanceof Aluno){
                //pagina aluno
                //botão histórico
                //botão exercitar
            }else if(u instanceof Professor){
                //pagina professor
                //cadastrar perfil
                //criar pergunta
            }
        }else{
            System.out.println("Falha no login.");
        }
    }

    //exibe o menu inicial. usado em init()
    private void menuInicial(){
        System.out.println("\n-----MAGICIAN-----");
        //pra testar
        System.out.println("1 - login");
        System.out.println("2 - sair");
        System.out.print("Escolha uma opção: ");
    }

    public void init(){
        boolean on = true;

        while(on){
            menuInicial();
            int opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    fazerLogin();
                    break;
                case 2:
                    on = false;
                    break;
                default:
                    System.out.println("Tente novamente.");
            }
        }
    }
}