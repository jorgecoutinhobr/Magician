package com.demo.Controllers;

import com.demo.Support.SingletonUsuario;
import com.demo.Support.SingletonView;
import com.demo.Models.*;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
  public Text errormessage;
  public TextField email;
  public PasswordField senha;
  public Button loginbtn;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    loginbtn.setOnAction(actionEvent -> onLogin());
  }

  private void onLogin() {
    String semail = email.getText().toLowerCase().trim();
    String ssenha = senha.getText();
    String[] niveltipo = Usuario.autenticar(semail, ssenha);
    if (niveltipo != null) {
      if (niveltipo[1].equals("a")) {
        Aluno alunoLogado = new Aluno(semail, ssenha, niveltipo[0]);
        SingletonUsuario.getInstancia().setAlunoLogado(alunoLogado);
        Stage currentStage = (Stage) loginbtn.getScene().getWindow();
        currentStage.close();
        SingletonView.getInstance().getView().showAlunoMenuWindow();
      } else {
        Professor professorLogado = new Professor(semail, ssenha);
        SingletonUsuario.getInstancia().setProfessorLogado(professorLogado);
        Stage currentStage = (Stage) loginbtn.getScene().getWindow();
        currentStage.close();
        SingletonView.getInstance().getView().showProfessorWindow();
      }
    } else {
      errormessage.setText("Erro: Verifique se os campos foram digitados corretamente");
    }
  }
}