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
    public Button btnSair;

   public void initialize(String email){
     exercitar.setOnAction(event -> exercitarPergunta());
     btnSair.setOnAction(event -> retornarLogin());
     historico.setOnAction(event -> historicoClicked());

     ArrayList<String> array = Busca.usuario(email);
     String nomeCompleto = array.get(2);
     String[] partesNome = nomeCompleto.split(" ");
     String nome = partesNome[0];
     bv.setText("Bem vindo, " + nome);
     bemail.setText(email);
   }

   private void exercitarPergunta(){
      Stage currentStage = (Stage) exercitar.getScene().getWindow();
      currentStage.close();
      Classe.getInstance().getView().showExercitarWindow();
   }

  private void retornarLogin() {
    Stage currentStage = (Stage) btnSair.getScene().getWindow();
    currentStage.close();
    Classe.getInstance().getView().showLoginWindow();
  }

    private void historicoClicked(){
        Stage currentStage = (Stage) historico.getScene().getWindow();
        currentStage.close();
        Classe.getInstance().getView().showHistoricoWindow();
    }


}
