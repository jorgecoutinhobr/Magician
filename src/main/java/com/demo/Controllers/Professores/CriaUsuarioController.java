package com.demo.Controllers.Professores;

import com.demo.Classes.Busca;
import com.demo.Classes.Classe;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
  public ChoiceBox<String> nivel;

  public void initialize() {
    nivel.getItems().addAll("1", "2", "3", "4");
    criar.setOnAction(event -> salvaUsuario());
    voltar.setOnAction(event -> voltarTela());
  }

  private void salvaUsuario() {
    if (tipo.getText().equals("a") && (uemail.getText().isEmpty() || nivel.getValue() == null || senha.getText().isEmpty() || nome.getText().isEmpty() || tipo.getText().isEmpty())) {
      mensagemresposta.setFill(Color.RED);
      mensagemresposta.setText("Todos os campos devem ser preenchidos");
      return;
    }

    if (tipo.getText().equals("p") && (uemail.getText().isEmpty() || senha.getText().isEmpty() || nome.getText().isEmpty() || tipo.getText().isEmpty())) {
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

      if (tipo.getText().equals("a")) {
        String dados = String.format("%s,%s,%s,%s,%s\n",
                uemail.getText().toLowerCase(),
                senha.getText(),
                nome.getText(),
                nivel.getValue(),
                tipo.getText());
        out.print(dados);
        mensagemresposta.setFill(Color.BLACK);
        mensagemresposta.setText("Usuário cadastrado com sucesso");
        limparCampos();
      } else if (tipo.getText().equals("p")) {
        String dados = String.format("%s,%s,%s,%s\n",
                uemail.getText().toLowerCase(),
                senha.getText(),
                nome.getText(),
                tipo.getText());
        out.print(dados);
        mensagemresposta.setFill(Color.BLACK);
        mensagemresposta.setText("Usuário cadastrado com sucesso");
        limparCampos();
      }

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
