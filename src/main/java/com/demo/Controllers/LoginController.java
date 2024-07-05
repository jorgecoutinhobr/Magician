package com.demo.Controllers;

import com.demo.Classes.Classe;
import com.demo.Classes.Usuario;
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
    String semail = email.getText();
    String ssenha = senha.getText();
    String tipo = Usuario.autenticar(semail, ssenha);
    if(tipo.equals("a")) {
      Stage currentStage = (Stage) loginbtn.getScene().getWindow();
      currentStage.close();
      Classe.getInstance().getView().showAlunoWindow();
    }
  }
}