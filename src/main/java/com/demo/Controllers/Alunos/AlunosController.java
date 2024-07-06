package com.demo.Controllers.Alunos;

import com.demo.Classes.Busca;
import com.demo.Classes.Classe;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;

public class AlunosController {
    @FXML
    public Text bv;
    public Text bemail;
    public Button exercitar;
    public Button historico;

   public void initialize(String email){
     exercitar.setOnAction(event -> exercitarPergunta());
     ArrayList<String> array = Busca.usuario(email);
     int index = array.get(2).indexOf(" ");
     String nome;
     if (index != -1) {
       nome = array.get(2).substring(0, index);
     } else {
       nome = array.get(2);
     }
     bv.setText("Bem Vindo, " + nome);
     bemail.setText(email);
   }

   private void exercitarPergunta(){
      Stage currentStage = (Stage) exercitar.getScene().getWindow();
      currentStage.close();
      Classe.getInstance().getView().showExercitarWindow();
   }
}
