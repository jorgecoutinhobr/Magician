package com.demo.Controllers.Professores;

import com.demo.Models.Busca;
import com.demo.Models.GerenciadorDeView;
import com.demo.Models.Performance;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AlteraUsuarioController {
  private final String PATH_USUARIOS = "src/main/java/com/demo/Database/usuarios.csv";
  public Button voltar;
  public Button alterar;
  public Button buscar;
  public TextField emailText;
  public TextField nomeText;
  public TextField senhaText;
  public Label nivelText;
  public Label performanceText;
  public Label nivelTitle;
  public Label performanceTitle;
  public Button subirNivel;
  public Button descerNivel;
  public Text mensagemresposta;
  private ArrayList<String> usuario;
  private ArrayList<String> aperformance;
  private String uemail;
  private String usenha;
  private String unome;
  private String anivel = "";

  public void initialize() {
    subirNivel.setVisible(false);
    descerNivel.setVisible(false);
    alterar.setVisible(false);
    nomeText.setVisible(false);
    senhaText.setVisible(false);
    nivelText.setVisible(false);
    performanceText.setVisible(false);
    nivelTitle.setVisible(false);
    performanceTitle.setVisible(false);
    voltar.setOnAction(event -> voltarParaProfessores());
    buscar.setOnAction(event -> buscarUsuario());
    alterar.setOnAction(event -> alteraUsuario());
    subirNivel.setOnAction(event -> sobeNivel());
    descerNivel.setOnAction(event -> desceNivel());
  }

  private void voltarParaProfessores() {
    Stage stage = (Stage) voltar.getScene().getWindow();
    stage.close();
    GerenciadorDeView.getInstance().getView().showProfessorWindow();
  }

  private void buscarUsuario() {
    usuario = Busca.usuario(emailText.getText().toLowerCase().trim());
    if (usuario == null) {
      mensagemresposta.setFill(Color.RED);
      mensagemresposta.setText("Usuário não encontrado");
    } else {
      uemail = emailText.getText().toLowerCase().trim();
      aperformance = Busca.performance(uemail);
      if (usuario.getLast().equals("a")) {
        mostraAluno();
      } else {
        mostraProfessor();
      }
    }
  }

  private void alteraUsuario(String... nivel) {
    ArrayList<String> linhas = new ArrayList<>();
    boolean encontrouEmail = false;
    usenha = senhaText.getText();
    unome = nomeText.getText();
    if (nivel.length > 0) {
      anivel = nivel[0];
    }
    try (BufferedReader reader = new BufferedReader(new FileReader(PATH_USUARIOS))) {
      String linha;
      while ((linha = reader.readLine()) != null) {
        String[] campos = linha.split(",");
        if (campos[0].equals(uemail)) {
          if (anivel != "")
            linhas.add(uemail +
                    "," +
                    usenha +
                    "," +
                    unome +
                    "," +
                    anivel +
                    ",a"
            );
          else linhas.add(uemail +
                  "," +
                  usenha +
                  "," +
                  unome +
                  "," +
                  "p"
          );
          encontrouEmail = true;
        } else {
          linhas.add(linha);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (encontrouEmail) {
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH_USUARIOS))) {
        for (String linhaAtualizada : linhas) {
          writer.write(linhaAtualizada);
          writer.newLine();
        }
        mensagemresposta.setFill(Color.BLACK);
        mensagemresposta.setText("Alteração realizada com sucesso!");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    usuario = Busca.usuario(uemail);
  }

  private void sobeNivel() {
    String novaperformace = uemail + ",0,0,[]";
    Performance.salvaPerformance(novaperformace, uemail);
    alteraUsuario(String.valueOf(Integer.parseInt(anivel) + 1));
    aperformance.clear();
    aperformance.addAll(Arrays.asList(novaperformace.split(",")));
    mostraAluno();
  }

  private void desceNivel() {
    String novaperformace = uemail + ",0,0,[]";
    Performance.salvaPerformance(novaperformace, uemail);
    alteraUsuario(String.valueOf(Integer.parseInt(anivel) - 1));
    aperformance.clear();
    aperformance.addAll(Arrays.asList(novaperformace.split(",")));
    mostraAluno();
  }

  private void mostraAluno() {
    nomeText.setText(usuario.get(2));
    senhaText.setText(usuario.get(1));
    anivel = usuario.get(3);
    nomeText.setVisible(true);
    senhaText.setVisible(true);
    performanceText.setVisible(true);
    nivelText.setVisible(true);
    performanceTitle.setVisible(true);
    nivelTitle.setVisible(true);
    alterar.setVisible(true);
    nivelText.setText(Performance.showNivel(uemail));
    if (Integer.parseInt(anivel) < 4)
      subirNivel.setVisible(true);
    else subirNivel.setVisible(false);
    if (Integer.parseInt(anivel) > 1)
      descerNivel.setVisible(true);
    else descerNivel.setVisible(false);
    double numAcertos = Double.parseDouble(aperformance.get(1));
    double numRespostas = Double.parseDouble(aperformance.get(2));
    double porcento;
    if (numRespostas != 0) {
      porcento = numAcertos / numRespostas;
    } else {
      porcento = numRespostas;
    }
    performanceText.setText("Questões respondidas: " +
            (int) numAcertos +
            "\nAcertos: " +
            (int) numRespostas +
            "\n(" +
            String.format("%.1f", porcento * 100) +
            "%)");
  }

  private void mostraProfessor() {
    anivel = "";
    nomeText.setText(usuario.get(2));
    senhaText.setText(usuario.get(1));
    nomeText.setVisible(true);
    senhaText.setVisible(true);
    alterar.setVisible(true);
    subirNivel.setVisible(false);
    performanceText.setVisible(false);
    nivelText.setVisible(false);
    performanceTitle.setVisible(false);
    nivelTitle.setVisible(false);
  }
}
