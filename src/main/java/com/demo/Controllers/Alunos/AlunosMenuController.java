package com.demo.Controllers.Alunos;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import javafx.scene.control.Label;

public class AlunosMenuController {
    @FXML
  public Text bv;
    public Text bemail;

 public void initialize(){
      String nome = "Jorge";
      bv.setText("Bem Vindo, " + nome);
    }
}
