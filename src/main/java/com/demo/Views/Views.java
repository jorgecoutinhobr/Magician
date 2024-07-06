package com.demo.Views;

import com.demo.Classes.Aluno;
import com.demo.Classes.ContextoAplicacao;
import com.demo.Classes.Professor;
import com.demo.Controllers.Alunos.AlunosController;
import com.demo.Controllers.Alunos.ExercitarController;
import com.demo.Controllers.Alunos.HistoricoController;
import com.demo.Controllers.Professores.CriaUsuarioController;
import com.demo.Controllers.Professores.CriarPerguntaController;
import com.demo.Controllers.Professores.ProfessoresController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Views {
  // Alunos
  private AnchorPane alunoMenu;

  public Views(){}

  public AnchorPane getAlunoMenu() {
    // otimizacao carregamento de telas
    if (alunoMenu == null) {
      try{
        alunoMenu = new FXMLLoader(getClass().getResource("/com/demo/Aluno/AlunoMenu.fxml")).load();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return  alunoMenu;
  }

  public void showLoginWindow(){
    FXMLLoader loader = new FXMLLoader( getClass().getResource("/com/demo/Login.fxml"));
    createStage(loader);
  }

  public void showAlunoMenuWindow() {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/demo/Aluno/AlunoMenu.fxml"));
    AlunosController alunosController = new AlunosController();
    loader.setController(alunosController);
    createStage(loader);
    Aluno alunoLogado = ContextoAplicacao.getInstancia().getAlunoLogado();
    alunosController.initialize(alunoLogado.getEmail());
  }

  public void showProfessorWindow() {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/demo/Professor/Professor.fxml"));
    ProfessoresController professoresController = new ProfessoresController();
    loader.setController(professoresController);
    createStage(loader);
    Professor professorLogado = ContextoAplicacao.getInstancia().getProfessorLogado();
    professoresController.initialize(professorLogado.getEmail());
  }

  public void showCriaPerguntaWindow(){
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
    Aluno alunoLogado = ContextoAplicacao.getInstancia().getAlunoLogado();
    exercitarController.initialize(alunoLogado.getNivel(), alunoLogado.getEmail());
  }

  public void showHistoricoWindow() {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/demo/Aluno/Historico.fxml"));
    HistoricoController historicoController = new HistoricoController();
    loader.setController(historicoController);
    createStage(loader);
    Aluno alunoLogado = ContextoAplicacao.getInstancia().getAlunoLogado();
    historicoController.initialize(alunoLogado.getEmail());
  }

  public void createStage(FXMLLoader loader){
    Scene scene = null;
    try{
      scene = new Scene(loader.load());
    } catch (Exception e) {
      e.printStackTrace();
    }
    Stage stage = new Stage();
    stage.setScene(scene);
    stage.setTitle("Magician");
    // NO ubuntu estou tendo um erro de tmanho de tela ao entrar em novas telas
    // o codigo abaixo resolve, porem sera preciso definir um tamanho padrao para todas as telas
    stage.setResizable(false);
    stage.show();
  }
}
