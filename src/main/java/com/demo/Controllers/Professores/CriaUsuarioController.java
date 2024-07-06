package com.demo.Controllers.Professores;

import com.demo.Classes.Classe;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CriaUsuarioController {
  final String PATH_USUARIOS = "src/main/java/com/demo/Database/usuarios.csv";

  @FXML
  public TextField uemail;
  public TextField senha;
  public TextField nome;
  public TextField tipo;
  public Button criar;
  public Button voltar;


  public void initialize(){
    criar.setOnAction(event -> salvaUsuario());
    voltar.setOnAction(event -> voltarTela());
  }

  private void salvaUsuario(){
    try {
      FileWriter fw = new FileWriter(PATH_USUARIOS, true);
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter out = new PrintWriter(bw);

      String dados = String.format("%s,%s,%s,%s\n",
              uemail.getText(),
              senha.getText(),
              nome.getText(),
              tipo.getText());

      out.print(dados);
      out.close();

      limparCampos();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void limparCampos() {
    uemail.clear();
    senha.clear();
    nome.clear();
    tipo.clear();
  }

  private void voltarTela(){
    Stage stage = (Stage) voltar.getScene().getWindow();
    stage.close();
    Classe.getInstance().getView().showProfessorWindow();
  }
}
