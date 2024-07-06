package com.demo.Controllers.Professores;

import com.demo.Classes.Classe;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CriarPerguntaController {

  @FXML
  public Text mensagemresposta;
  public ChoiceBox<String> nivel;
  public TextField intro;
  public TextField pergunta;
  public TextField op1;
  public TextField op2;
  public TextField op3;
  public TextField op4;
  public TextField resposta;
  public Button enviar;
  public Button voltar;

  public void initialize(){
    nivel.getItems().addAll("1","2","3","4");
    enviar.setOnAction(event -> salvaPergunta());
    voltar.setOnAction(event -> voltarParaProfessores());
  }

  private void salvaPergunta(){
    try {
      if(     intro.getText().equals("") ||
              pergunta.getText().equals("") ||
              op1.getText().equals("") ||
              op2.getText().equals("") ||
              op3.getText().equals("") ||
              op4.getText().equals("") ||
              resposta.getText().equals("") ||
              nivel == null)
      {
        mensagemresposta.setFill(Color.RED);
        mensagemresposta.setText("Erro: prencha todo os campos");
      }
      else {
        String PATH_PERGUNTAS = "src/main/java/com/demo/Database/nivel" + nivel.getValue() + ".csv";
        FileWriter fw = new FileWriter(PATH_PERGUNTAS, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        String dados = String.format("%s,%s,%s,%s,%s,%s,%s\n",
                intro.getText(),
                pergunta.getText(),
                op1.getText(),
                op2.getText(),
                op3.getText(),
                op4.getText(),
                resposta.getText());
        nivel.getValue();

        out.print(dados);
        out.close();
        mensagemresposta.setFill(Color.BLACK);
        mensagemresposta.setText("Pergunta enviada");
        limparCampos();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void limparCampos() {
    intro.clear();
    pergunta.clear();
    op1.clear();
    op2.clear();
    op3.clear();
    op4.clear();
    resposta.clear();
    nivel.setValue("");
  }

  private void voltarParaProfessores(){
    Stage stage = (Stage) voltar.getScene().getWindow();
    stage.close();
    Classe.getInstance().getView().showProfessorWindow();
  }
}
