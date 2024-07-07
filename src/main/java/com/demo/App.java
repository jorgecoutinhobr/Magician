package com.demo;

import com.demo.Classes.*;
import com.demo.Views.Views;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.*;

public class App extends Application {
  @Override
  public void start(Stage stage)  {
    Views view = new Views();
    view.showLoginWindow();
  }
}
