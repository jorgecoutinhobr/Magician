package com.demo.Controllers.Professores;

import com.demo.Classes.Busca;
import com.demo.Classes.Classe;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
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
  public Text mensagemresposta;

  public void initialize() {
    criar.setOnAction(event -> salvaUsuario());
    voltar.setOnAction(event -> voltarTela());
  }

  private void salvaUsuario() {
    if (uemail.getText().isEmpty() || senha.getText().isEmpty() || nome.getText().isEmpty() || tipo.getText().isEmpty()) {
      mensagemresposta.setFill(Color.RED);
      mensagemresposta.setText("Todos os campos devem ser preenchidos");
      return;
    }

    if (!tipo.getText().equals("a") && !tipo.getText().equals("p")) {
      mensagemresposta.setFill(Color.RED);
      mensagemresposta.setText("Tipo não reconhecido");
      return;
    }

    if (Busca.usuario(uemail.getText()) != null) {
      mensagemresposta.setFill(Color.RED);
      mensagemresposta.setText("Usuário já cadastrado");
      return;
    }

    try (FileWriter fw = new FileWriter(PATH_USUARIOS, true);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter out = new PrintWriter(bw)) {

      String dados = String.format("%s,%s,%s,1,%s\n",
              uemail.getText().toLowerCase(),
              senha.getText(),
              nome.getText(),
              tipo.getText());
      out.print(dados);
      mensagemresposta.setFill(Color.BLACK);
      mensagemresposta.setText("Usuário cadastrado com sucesso");
      limparCampos();

    } catch (IOException e) {
      mensagemresposta.setFill(Color.RED);
      mensagemresposta.setText("Erro ao salvar o usuário");
      e.printStackTrace();
    }
  }


  private void limparCampos() {
    uemail.clear();
    senha.clear();
    nome.clear();
    tipo.clear();
  }

  private void voltarTela() {
    Stage stage = (Stage) voltar.getScene().getWindow();
    stage.close();
    Classe.getInstance().getView().showProfessorWindow();
  }
}
