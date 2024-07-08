package com.demo.Controllers.Professores;

import com.demo.Models.Busca;
import com.demo.Models.GerenciadorDeView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
  public TextField nome;;
  public Button criar;
  public Button voltar;
  public ChoiceBox<String> tipo;
  public ChoiceBox<String> nivel;
  public Text mensagemresposta;
  public Text nivelText;
  public Text tipoText;
  private String atipo = "";

  public void initialize() {
    nivel.getItems().addAll("1", "2", "3", "4");
    tipo.getItems().addAll("Aluno","Professor");
    nivelText.setMouseTransparent(true);
    tipoText.setMouseTransparent(true);
    nivel.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
      @Override
      public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
        if(t1 != null){
          nivelText.setVisible(false);
        }
      }
    });
    tipo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
      @Override
      public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
        if(t1 != null){
          tipoText.setVisible(false);
        }
      }
    });
    criar.setOnAction(event -> adicionaUsuario());
    voltar.setOnAction(event -> voltarTela());
  }

  private void adicionaUsuario() {
    if(tipo.getValue() == "Aluno")
      atipo = "a";
    else if (tipo.getValue() == "Professor")
      atipo = "p";
    if (atipo.equals("a") && (uemail.getText().isEmpty() || nivel.getValue() == null || senha.getText().isEmpty() || nome.getText().isEmpty() || atipo.isEmpty())) {
      mensagemresposta.setFill(Color.RED);
      mensagemresposta.setText("Todos os campos devem ser preenchidos");
      return;
    }

    if (atipo.equals("p") && (uemail.getText().isEmpty() || senha.getText().isEmpty() || nome.getText().isEmpty() || atipo.isEmpty())) {
      mensagemresposta.setFill(Color.RED);
      mensagemresposta.setText("Todos os campos devem ser preenchidos");
      return;
    }

    if(atipo.isEmpty()){
      mensagemresposta.setFill(Color.RED);
      mensagemresposta.setText("Todos os campos devem ser preenchidos");
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

      if (atipo.equals("a")) {
        String dados = String.format("%s,%s,%s,%s,%s\n",
                uemail.getText().toLowerCase(),
                senha.getText(),
                nome.getText(),
                nivel.getValue(),
                atipo);
        out.print(dados);
        mensagemresposta.setFill(Color.BLACK);
        mensagemresposta.setText("Usuário cadastrado com sucesso");
        limparCampos();
      } else if (atipo.equals("p")) {
        String dados = String.format("%s,%s,%s,%s\n",
                uemail.getText().toLowerCase(),
                senha.getText(),
                nome.getText(),
                atipo);
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
    tipo.setValue("");
    nivel.setValue("");
    tipoText.setVisible(true);
    nivelText.setVisible(true);
  }

  private void voltarTela() {
    Stage stage = (Stage) voltar.getScene().getWindow();
    stage.close();
    GerenciadorDeView.getInstance().getView().showProfessorWindow();
  }
}

