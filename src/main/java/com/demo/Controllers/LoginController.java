package com.demo.Controllers;

import com.demo.Managers.GerenciadorDeUsuario;
import com.demo.Managers.GerenciadorDeView;
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
        GerenciadorDeUsuario.getInstancia().setAlunoLogado(alunoLogado);
        Stage currentStage = (Stage) loginbtn.getScene().getWindow();
        currentStage.close();
        GerenciadorDeView.getInstance().getView().showAlunoMenuWindow();
      } else {
        Professor professorLogado = new Professor(semail, ssenha);
        GerenciadorDeUsuario.getInstancia().setProfessorLogado(professorLogado);
        Stage currentStage = (Stage) loginbtn.getScene().getWindow();
        currentStage.close();
        GerenciadorDeView.getInstance().getView().showProfessorWindow();
      }
    } else {
      errormessage.setText("Erro: Verifique se os campos foram digitados corretamente");
    }
  }
}