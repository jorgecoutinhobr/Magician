package com.demo.Controllers;

import com.demo.Classes.*;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

  public TextField email;
  public PasswordField senha;
  public Button loginbtn;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    loginbtn.setOnAction(actionEvent -> onLogin());
  }

  private void onLogin(){
    String semail = email.getText().toLowerCase();
    String ssenha = senha.getText();
    String tipo = Usuario.autenticar(semail, ssenha);
    if(tipo.equals("a")) {
      Aluno alunoLogado = new Aluno(semail,ssenha);
      ContextoAplicacao.getInstancia().setAlunoLogado(alunoLogado);
      Stage currentStage = (Stage) loginbtn.getScene().getWindow();
      currentStage.close();
      Classe.getInstance().getView().showAlunoMenuWindow();
    } else {
      Professor professorLogado = new Professor(semail, ssenha);
      ContextoAplicacao.getInstancia().setProfessorLogado(professorLogado);
      Stage currentStage = (Stage) loginbtn.getScene().getWindow();
      currentStage.close();
      Classe.getInstance().getView().showProfessorWindow();
    }
  }
}