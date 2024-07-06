package com.demo.Controllers.Alunos;

import com.demo.Classes.Busca;
import com.demo.Classes.Classe;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ExercitarController {
  @FXML
  public ToggleGroup group;
  public String resposta;
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

  public void initialize(String nivel){
    ArrayList<String> perguntas = atualizarPerguntas(nivel);
    responder.setOnAction(event -> responderPergunta(perguntas));
    voltar.setOnAction(event -> voltarParaAlunos());
  }
  private  void responderPergunta(ArrayList<String> perguntas){
    RadioButton radioButton = (RadioButton) group.getSelectedToggle();
    if(radioButton == null){
      mensagemresposta.setText("Selecione uma das alternativas");
    }
    else {
      mensagemresposta.setText("");
    if((radioButton.getId().substring(2,3)).equals(perguntas.get(perguntas.size()-2))){
      System.out.println("resposta certa");
    }
    }
  }
  private void voltarParaAlunos(){
    Stage stage = (Stage) voltar.getScene().getWindow();
    stage.close();
    Classe.getInstance().getView().showAlunoMenuWindow();
  }

  private ArrayList<String> atualizarPerguntas(String nivel){
    this.nivel.setText("Questão de nível " + nivel);
    ArrayList<String> perguntas = Busca.pergunta(nivel);
    intro.setText(perguntas.getFirst());
    pergunta.setText(perguntas.get(1));
    op1.setText(perguntas.get(2));
    op2.setText(perguntas.get(3));
    op3.setText(perguntas.get(4));
    op4.setText(perguntas.get(5));
    return perguntas;
  }
}
