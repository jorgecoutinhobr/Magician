package com.demo.Controllers.Professores;

import com.demo.Classes.Busca;
import com.demo.Classes.Classe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class ProfessoresController {
  @FXML
  public Text bv;
  public Button criapergunta;
  public Button criausuario;
  public Button btnSair;

  public void initialize(String email) {
    criapergunta.setOnAction(event -> criadorPergunta());
    criausuario.setOnAction(event -> criadorUsuario());
    btnSair.setOnAction(event -> retornarLogin());
    ArrayList<String> array = Busca.usuario(email);
    String nomeCompleto = array.get(2);
    String[] partesNome = nomeCompleto.split(" ");
    String nome = partesNome[0];
    bv.setText("Bem Vindo, " + nome);
  }

  private void criadorPergunta() {
    Stage currentStage = (Stage) criapergunta.getScene().getWindow();
    currentStage.close();
    Classe.getInstance().getView().showCriaPerguntaWindow();
  }

  private void criadorUsuario() {
    Stage currentStage = (Stage) criausuario.getScene().getWindow();
    currentStage.close();
    Classe.getInstance().getView().showCriaUsuarioWindow();
  }

  private void retornarLogin() {
    Stage currentStage = (Stage) btnSair.getScene().getWindow();
    currentStage.close();
    Classe.getInstance().getView().showLoginWindow();
  }

}
