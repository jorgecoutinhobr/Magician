package com.demo.Controllers.Alunos;

import com.demo.Classes.Busca;
import com.demo.Classes.Classe;
import com.demo.Classes.Performance;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ExercitarController {
  @FXML
  public ToggleGroup grupoop;
  public Text nivel;
  public Text intro;
  public Text pergunta;
  public RadioButton op1;
  public RadioButton op2;
  public RadioButton op3;
  public RadioButton op4;
  public Button responder;
  public Button voltar;
  public Text mensagemresposta;

  private int count = 0;
  private String anivel;
  private String aemail;
  private double numAcertos = 0;
  private double numRespostas = 0;
  private ArrayList<String> aperguntas;

  public void initialize(String nivel, String email) {
    aemail = email;
    anivel = nivel;
    aperguntas = atualizarPerguntas();
    responder.setOnAction(event -> responderPergunta());
    voltar.setOnAction(event -> voltarParaAlunos());
  }

  private void responderPergunta() {
    boolean certa = false;
    RadioButton radioButton = (RadioButton) grupoop.getSelectedToggle();
    if (radioButton == null) {
      mensagemresposta.setText("Selecione uma das alternativas");
    } else {
      mensagemresposta.setText("");
      if ((radioButton.getId().substring(2, 3)).equals(aperguntas.get(aperguntas.size() - 2))) {
        certa = true;
        numAcertos++;
      }
      radioButton.setSelected(false);
      Performance.addResposta(aemail, certa, aperguntas.getLast());
      numRespostas++;
      count++;
      aperguntas.clear();
      aperguntas.addAll(atualizarPerguntas());
      verificaTotalPeguntas();
    }
  }

  private void voltarParaAlunos() {
    Stage stage = (Stage) voltar.getScene().getWindow();
    stage.close();
    Classe.getInstance().getView().showAlunoMenuWindow();
    if (count > 0) {
      Alert alerta = new Alert(Alert.AlertType.INFORMATION);
      alerta.setTitle("");
      alerta.setHeaderText("Resultados");
      alerta.setContentText("Pontuação: " + (int) numAcertos + "/" + (int) numRespostas + "\n" + String.format("%.1f", (numAcertos / numRespostas) * 100) + "%");
      alerta.showAndWait();
    }
  }

  private ArrayList<String> atualizarPerguntas() {
    this.nivel.setText("Exercício - " + Performance.showNivel(aemail));
    ArrayList<String> perguntas = Busca.pergunta(anivel, aemail);
    if (perguntas == null) {
      voltarParaAlunos();
    } else {
      intro.setText(perguntas.getFirst());
      pergunta.setText(perguntas.get(1));
      op1.setText(perguntas.get(2));
      op2.setText(perguntas.get(3));
      op3.setText(perguntas.get(4));
      op4.setText(perguntas.get(5));
      return perguntas;
    }
    return new ArrayList<>();
  }

  private void verificaTotalPeguntas() {
    if (this.count == 5) {
      voltarParaAlunos();
    }
  }
}
