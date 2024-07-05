package com.demo.Views;

import com.demo.Controllers.Alunos.AlunosMenuController;
import com.demo.Controllers.Professores.CriarPerguntaController;
import com.demo.Controllers.Professores.ProfessoresController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Views {
  // Alunos
  private AnchorPane alunoMenu;

  public Views(){}

  public AnchorPane getAlunoMenu() {
    // otimizacao carregamento de telas
    if (alunoMenu == null) {
      try{
        alunoMenu = new FXMLLoader(getClass().getResource("/com/demo/Aluno/AlunoMenu.fxml")).load();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return  alunoMenu;
  }

  public void showLoginWindow(){
    FXMLLoader loader = new FXMLLoader( getClass().getResource("/com/demo/Login.fxml"));
    createStage(loader);
  }

  public void showAlunoMenuWindow(String email) {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/demo/Aluno/AlunoMenu.fxml"));
    AlunosMenuController alunosController = new AlunosMenuController();
    loader.setController(alunosController);
    createStage(loader);
    alunosController.initialize(email);
  }

  public void showProfessorWindow(String nome) {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/demo/Professor/Professor.fxml"));
    ProfessoresController professoresController = new ProfessoresController();
    loader.setController(professoresController);
    createStage(loader);
    professoresController.initialize(nome);
  }

  public void showCriaPerguntaWindow(){
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/demo/Professor/CriarPergunta.fxml"));
    CriarPerguntaController criarPerguntaController = new CriarPerguntaController();
    loader.setController(criarPerguntaController);
    createStage(loader);
  }

  public void createStage(FXMLLoader loader){
    Scene scene = null;
    try{
      scene = new Scene(loader.load());
    } catch (Exception e) {
      e.printStackTrace();
    }
    Stage stage = new Stage();
    stage.setScene(scene);
    stage.setTitle("Magician");
    // NO ubuntu estou tendo um erro de tmanho de tela ao entrar em novas telas
    // o codigo abaixo resolve, porem sera preciso definir um tamanho padrao para todas as telas
    //  stage.setResizable(false);
    stage.show();
  }

}
