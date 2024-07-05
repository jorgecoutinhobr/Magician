package com.demo.Controllers.Alunos;

import com.demo.Classes.Aluno;
import com.demo.Classes.Busca;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class AlunosMenuController {
    @FXML
    public Text bv;
    public Text bemail;

 public void initialize(String email){
      ArrayList<String> array = Busca.usuario(email);
      int index = array.get(2).indexOf(" ",0);
      String nome = array.get(2).substring(0,index);
      bv.setText("Bem Vindo, " + nome);
      bemail.setText(email);
    }
}
