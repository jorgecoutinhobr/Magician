package com.demo.Controllers.Alunos;

import com.demo.Classes.Busca;
import com.demo.Classes.Classe;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;

public class HistoricoController {
    @FXML
    public Label hemail;
    public Label nivel;
    public Label performance;
    public Button backbtn;


    public void initialize(String email){
        backbtn.setOnAction(actionEvent -> backPage());
        ArrayList<String> list = Busca.performance(email);
        double numAcertos = Double.parseDouble(list.get(1));
        double numRespostas = Double.parseDouble(list.get(2));
        double porcento = numAcertos/numRespostas;
        performance.setText(numAcertos + "/" + numRespostas + "(" + porcento + "%)");
        nivel.setText(showNivel(email));
        hemail.setText(email);
    }

    public String showNivel(String email){
        ArrayList<String> list = Busca.usuario(email);
        assert list != null;
        if(list.get(3).equals("2")){
            return "Intermediário";
        }else if(list.get(3).equals("3")){
            return "Avançado";
        }else if(list.get(3).equals("4")){
            return "Fluente";
        }else if(list.get(3).equals("1")){
            return "Iniciante";
        }
        return null;
    }

    public void backPage(){
        Stage currentStage = (Stage) backbtn.getScene().getWindow();
        currentStage.close();
        Classe.getInstance().getView().showAlunoMenuWindow();
    }
}
