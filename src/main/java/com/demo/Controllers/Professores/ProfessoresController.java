package com.demo.Controllers.Professores;

import com.demo.Classes.Busca;
import com.demo.Classes.Classe;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;

public class ProfessoresController {
  @FXML
  public Text bv;
  public Button criapergunta;
  public Button criausuario;

  public void initialize(String email) {
    criapergunta.setOnAction(event -> criadorPergunta());
    criausuario.setOnAction(event -> criadorUsuario());
    ArrayList<String> array = Busca.usuario(email);
    int index = array.get(2).indexOf(" ");
    String nome;
    if (index != -1) {
      nome = array.get(2).substring(0, index);
    } else {
      nome = array.get(2);
    }
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
}
