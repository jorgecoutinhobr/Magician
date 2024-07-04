package com.demo.Controllers;

import com.demo.Classes.Classe;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

  public TextField email;
  public PasswordField senha;
  public Button loginbtn;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    loginbtn.setOnAction(actionEvent -> {
      try {
        Classe.getInstance().getView().showAlunoWindow();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    });
  }
}
