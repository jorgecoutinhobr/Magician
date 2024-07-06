package com.demo.Controllers.Alunos;

import com.demo.Classes.Aluno;
import com.demo.Classes.Busca;
import com.demo.Classes.Classe;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ExercitarController {
  public ToggleGroup group;
  public String resposta;
  public Text intro;
  public Button enviar;
  public Button voltar;

  public void initialize(String nivel){
    enviar.setOnAction(event -> responderPergunta());
    voltar.setOnAction(event -> voltarParaAlunos());
  }
  private void selecionarResposta(RadioButton test){
  }
  private  void responderPergunta(){
    RadioButton radioButton = (RadioButton) group.getSelectedToggle();
    if(radioButton == null){
      System.out.println("teste");
    }
    else {
      System.out.println("enviado");
    }
  }
  private void voltarParaAlunos(){
    Stage stage = (Stage) voltar.getScene().getWindow();
    stage.close();
    Classe.getInstance().getView().showAlunoMenuWindow();
  }
}
