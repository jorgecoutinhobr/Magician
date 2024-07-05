package com.demo.Controllers.Professores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CriarPerguntaController {
  final String PATH_PERGUNTAS = "src/main/java/com/demo/Database/perguntas.csv";

  @FXML
  public TextField intro;
  public TextField pergunta;
  public TextField op1;
  public TextField op2;
  public TextField op3;
  public TextField op4;
  public TextField resposta;
  public Button enviar;

  public void initialize(){
    enviar.setOnAction(e -> salvaPergunta());
  }

private void salvaPergunta(){
  try {
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

    out.print(dados);
    out.close();
  } catch (IOException e) {
    e.printStackTrace();
  }
}
}
