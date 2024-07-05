package com.demo;

import com.demo.Classes.*;
import com.demo.Views.Views;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.*;

public class App extends Application {
 // private Scanner scanner = new Scanner(System.in);

  //autenticação do usuario. usado em fazerLogin()
  //scanneia dados, os autentica e direciona pra página do tipo de usuario. usado em init()
/*private int  fazerLogin(){
    System.out.println("Insira seu email: "); // Removido o System.out.print() extra
    scanner.nextLine();
    String email = scanner.nextLine();
    System.out.println("Insira sua senha: "); // Alterado para println para consistência
    String senha = scanner.nextLine();

    Usuario u = new Usuario();
    u = u.autenticar(email,senha);
    if(u != null){
      System.out.println("\nBem vindo!");
      if(u instanceof Aluno){
        System.out.println("Aluno");
        return 2;
        // Implementação específica para aluno
      }else if(u instanceof Professor){
        System.out.println("Professor");
        return 2;
        // Implementação específica para professor
      }
    }else{
      System.out.println("Falha no login.");
    }
    return 1;
}

 */

  //exibe o menu inicial. usado em init()
//  private void menuInicial(){
//    System.out.println("\n-----MAGICIAN-----");
//    //pra testar
//    System.out.println("1 - login");
//    System.out.println("2 - sair");
//    System.out.print("Escolha uma opção: ");
//  }

  /*public void init(){
    int opcao = 1;
    while(opcao == 1){
      menuInicial();
      opcao = scanner.nextInt();

      switch (opcao){
        case 1:
          opcao = fazerLogin();
          break;
        case 2:
          break;
        default:
          System.out.println("Tente novamente.");
      }
    }
  }
   */
  @Override
  public void start(Stage stage)  {
    Views view = new Views();
    view.showLoginWindow();
  }
}
