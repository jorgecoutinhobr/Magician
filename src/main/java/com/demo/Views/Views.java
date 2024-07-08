package com.demo.Views;

import com.demo.Models.Aluno;
import com.demo.Managers.GerenciadorDeUsuario;
import com.demo.Models.Professor;
import com.demo.Controllers.Alunos.AlunosController;
import com.demo.Controllers.Alunos.ExercitarController;
import com.demo.Controllers.Alunos.HistoricoController;
import com.demo.Controllers.Professores.AlteraUsuarioController;
import com.demo.Controllers.Professores.CriaUsuarioController;
import com.demo.Controllers.Professores.CriarPerguntaController;
import com.demo.Controllers.Professores.ProfessoresController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Views {
  public Views() {
  }

  public void showLoginWindow() {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/demo/Login.fxml"));
    createStage(loader);
  }

  public void showAlunoMenuWindow() {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/demo/Aluno/AlunoMenu.fxml"));
    AlunosController alunosController = new AlunosController();
    loader.setController(alunosController);
    createStage(loader);
    Aluno alunoLogado = GerenciadorDeUsuario.getInstancia().getAlunoLogado();
    alunosController.initialize(alunoLogado.getEmail());
  }

  public void showProfessorWindow() {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/demo/Professor/Professor.fxml"));
    ProfessoresController professoresController = new ProfessoresController();
    loader.setController(professoresController);
    createStage(loader);
    Professor professorLogado = GerenciadorDeUsuario.getInstancia().getProfessorLogado();
    professoresController.initialize(professorLogado.getEmail());
  }

  public void showCriaPerguntaWindow() {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/demo/Professor/CriarPergunta.fxml"));
    CriarPerguntaController criarPerguntaController = new CriarPerguntaController();
    loader.setController(criarPerguntaController);
    createStage(loader);
  }

  public void showCriaUsuarioWindow() {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/demo/Professor/CriaUsuario.fxml"));
    CriaUsuarioController criaUsuarioController = new CriaUsuarioController();
    loader.setController(criaUsuarioController);
    createStage(loader);
  }

  public void showExercitarWindow() {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/demo/Aluno/Exercitar.fxml"));
    ExercitarController exercitarController = new ExercitarController();
    loader.setController(exercitarController);
    createStage(loader);
    Aluno alunoLogado = GerenciadorDeUsuario.getInstancia().getAlunoLogado();
    exercitarController.initialize(alunoLogado.getNivel(), alunoLogado.getEmail());
  }

  public void showHistoricoWindow() {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/demo/Aluno/Historico.fxml"));
    HistoricoController historicoController = new HistoricoController();
    loader.setController(historicoController);
    createStage(loader);
    Aluno alunoLogado = GerenciadorDeUsuario.getInstancia().getAlunoLogado();
    historicoController.initialize(alunoLogado.getEmail());
  }

  public void showAlteraUsuarioWindow() {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/demo/Professor/AlteraUsuario.fxml"));
    AlteraUsuarioController alteraUsuarioController = new AlteraUsuarioController();
    loader.setController(alteraUsuarioController);
    createStage(loader);
  }

  private void createStage(FXMLLoader loader) {
    Scene scene = null;
    try {
      scene = new Scene(loader.load());
    } catch (Exception e) {
      e.printStackTrace();
    }
    Stage stage = new Stage();
    stage.setScene(scene);
    stage.setTitle("Magician");
    stage.setResizable(false);
    stage.show();
  }
}
