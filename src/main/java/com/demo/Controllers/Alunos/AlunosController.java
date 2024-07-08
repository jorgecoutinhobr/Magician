package com.demo.Controllers.Alunos;

import com.demo.Models.Busca;
import com.demo.Support.SingletonView;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AlunosController {
  @FXML
  public Text bv;
  public Text bemail;
  public Button exercitar;
  public Button historico;
  public Button btnSair;

  private ArrayList<String> aluno;
  private String aemail;
  private String anivel;

  public void initialize(String email) {
    exercitar.setOnAction(event -> exercitarPergunta());
    btnSair.setOnAction(event -> retornarLogin());
    historico.setOnAction(event -> historicoClicked());
    aemail = email;
    aluno = Busca.usuario(aemail);
    anivel = aluno.get(3);
    String nomeCompleto = aluno.get(2);
    String[] partesNome = nomeCompleto.split(" ");
    String nome = partesNome[0];
    bv.setText("Bem vindo, " + nome);
    bemail.setText(email);
  }

  private void exercitarPergunta() {
    ArrayList<String> pergunta = Busca.pergunta(anivel,aemail);
    if(pergunta == null){
      Alert alerta = new Alert(Alert.AlertType.WARNING);
      alerta.setTitle("");
      alerta.setHeaderText("Erro");
      alerta.setContentText("Não foi possível encontrar mais perguntas do seu nível!");
      alerta.showAndWait();
    }
    else {
      Stage currentStage = (Stage) exercitar.getScene().getWindow();
      currentStage.close();
      SingletonView.getInstance().getView().showExercitarWindow();
    }
  }

  private void retornarLogin() {
    Stage currentStage = (Stage) btnSair.getScene().getWindow();
    currentStage.close();
    SingletonView.getInstance().getView().showLoginWindow();
  }

  private void historicoClicked() {
    Stage currentStage = (Stage) historico.getScene().getWindow();
    currentStage.close();
    SingletonView.getInstance().getView().showHistoricoWindow();
  }


}
