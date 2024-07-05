package com.demo.Views;

import com.demo.Controllers.Alunos.AlunosController;
import com.demo.Controllers.Alunos.AlunosMenuController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.io.IOException;

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

  public void showAlunoWindow() {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/demo/Aluno/AlunoMenu.fxml"));
    AlunosController alunosController = new AlunosController();
    loader.setController(alunosController);
    AlunosMenuController a = new AlunosMenuController();
    a.initialize();
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
    stage.setTitle("Ola");
    stage.show();
  }

}
