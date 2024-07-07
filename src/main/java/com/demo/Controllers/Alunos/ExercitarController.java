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
  public int count;
  public String eemail;
  public String pperformance;
  double numAcertos = 0;
  double numRespostas = 0;;

  public void initialize(String nivel, String email) {
    ArrayList<String> perguntas = atualizarPerguntas(nivel, email);
    eemail = email;
    responder.setOnAction(event -> {++count;responderPergunta(perguntas, email);perguntas.clear();perguntas.addAll(atualizarPerguntas(nivel,email));});
    voltar.setOnAction(event -> voltarParaAlunos());
  }

  private void responderPergunta(ArrayList<String> perguntas, String email) {
    boolean certa = false;
    RadioButton radioButton = (RadioButton) grupoop.getSelectedToggle();
    if (radioButton == null) {
      mensagemresposta.setText("Selecione uma das alternativas");
    } else {
      mensagemresposta.setText("");
      if ((radioButton.getId().substring(2, 3)).equals(perguntas.get(perguntas.size() - 2))) {
        System.out.println("resposta certa");
        certa = true;
        numAcertos++;
      }
      radioButton.setSelected(false);
      Performance.addResposta(email, certa, perguntas.getLast());
      numRespostas++;
      verificaTotalPeguntas();
    }
  }

  private void voltarParaAlunos() {
    Stage stage = (Stage) voltar.getScene().getWindow();
    stage.close();
    Classe.getInstance().getView().showAlunoMenuWindow();
    if(count > 0) {
      Alert alerta = new Alert(Alert.AlertType.INFORMATION);
      alerta.setTitle("");
      alerta.setHeaderText("Resultados");
      alerta.setContentText("Pontuação: " + (int) numAcertos + "/" + (int) numRespostas + "\n" + String.format("%.1f",(numAcertos/numRespostas)*100) + "%");
      alerta.showAndWait();
    }
    else {
      Alert alerta = new Alert(Alert.AlertType.WARNING);
      alerta.setTitle("");
      alerta.setHeaderText("Erro");
      alerta.setContentText("Não foi possível encontrar mais perguntas do seu nível!");
      alerta.showAndWait();
    }
  }

  private ArrayList<String> atualizarPerguntas(String nivel, String email) {
    this.nivel.setText("Exercício - " + Performance.showNivel(email));
    ArrayList<String> perguntas = Busca.pergunta(nivel, email);
    if(perguntas == null){
      voltarParaAlunos();
    }
    else {
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

  private void verificaTotalPeguntas(){
    System.out.println(count);
    if(this.count == 5){
      voltarParaAlunos();
    }
  }
}
