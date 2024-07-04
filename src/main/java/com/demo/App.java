package com.demo;

import com.demo.Classes.Classe;
import com.demo.Views.Views;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

  @Override
  public void start(Stage stage)  {
//    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/demo/Login.fxml"));
//    Scene scene = new Scene(fxmlLoader.load());
//    stage.setScene(scene);
//    stage.show();

    Views view = new Views();
    view.showLoginWindow();
  }
}
