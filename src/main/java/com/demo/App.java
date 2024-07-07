package com.demo;

import com.demo.Views.Views;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
  @Override
  public void start(Stage stage) {
    Views view = new Views();
    view.showLoginWindow();
  }
}
