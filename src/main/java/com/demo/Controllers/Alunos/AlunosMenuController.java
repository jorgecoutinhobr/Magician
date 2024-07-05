package com.demo.Controllers.Alunos;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class AlunosMenuController {
    @FXML
  private Text ui;

    public void initialize(){
      String nome = "Jorge";
      ui.setText(nome);
    }
}
