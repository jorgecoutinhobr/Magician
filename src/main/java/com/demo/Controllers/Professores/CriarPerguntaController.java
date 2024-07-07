package com.demo.Controllers.Professores;

import com.demo.Classes.Busca;
import com.demo.Classes.Classe;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.*;

public class CriarPerguntaController {

  @FXML
  public Text mensagemresposta;
  public ChoiceBox<String> nivel;
  public TextArea intro;
  public TextField pergunta;
  public TextField op1;
  public TextField op2;
  public TextField op3;
  public TextField op4;
  public TextField resposta;
  public Button enviar;
  public Button voltar;

  public void initialize() {
    nivel.getItems().addAll("1", "2", "3", "4");
    enviar.setOnAction(event -> salvaPergunta());
    voltar.setOnAction(event -> voltarParaProfessores());
  }

  private void salvaPergunta() {
    if (intro.getText().equals("") ||
            pergunta.getText().equals("") ||
            op1.getText().equals("") ||
            op2.getText().equals("") ||
            op3.getText().equals("") ||
            op4.getText().equals("") ||
            resposta.getText().equals("") ||
            nivel.getValue() == null) {
      mensagemresposta.setFill(Color.RED);
      mensagemresposta.setText("Erro: prencha todo os campos");
      return;
    } else if (Integer.parseInt(resposta.getText()) < 1 || Integer.parseInt(resposta.getText()) > 4  )
    {
      mensagemresposta.setFill(Color.RED);
      mensagemresposta.setText("Erro: número da resposta inválido");
      return;
    }
    String PATH_PERGUNTAS = "src/main/java/com/demo/Database/nivel" + nivel.getValue() + ".csv";

    try (BufferedReader br = new BufferedReader(new FileReader(PATH_PERGUNTAS))) {
      String line;
      while ((line = br.readLine()) != null) {
        if (line.contains(intro.getText() + ";" + pergunta.getText() + ";")) {
          mensagemresposta.setFill(Color.RED);
          mensagemresposta.setText("Erro: A pergunta já existe.");
          return;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      FileWriter fw = new FileWriter(PATH_PERGUNTAS, true);
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter out = new PrintWriter(bw);
      int tamanho = Busca.tamanhoArquivo(PATH_PERGUNTAS) + 1;
      String dados = String.format("%s;%s;%s;%s;%s;%s;%s;%s\n",
              intro.getText(),
              pergunta.getText(),
              op1.getText(),
              op2.getText(),
              op3.getText(),
              op4.getText(),
              resposta.getText(),
              String.valueOf(tamanho));

      out.print(dados);
      out.close();
      mensagemresposta.setFill(Color.BLACK);
      mensagemresposta.setText("Pergunta enviada");
      limparCampos();
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

  private void voltarParaProfessores() {
    Stage stage = (Stage) voltar.getScene().getWindow();
    stage.close();
    Classe.getInstance().getView().showProfessorWindow();
  }
}
