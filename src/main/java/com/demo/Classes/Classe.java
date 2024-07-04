package com.demo.Classes;

import com.demo.Views.Views;

import javax.swing.text.View;

public class Classe {
  private final Views view;
  private static Classe classe;
  // singleton pattern
  private Classe() {
    this.view = new Views();
  }

  public static synchronized Classe getInstance() {
    if (classe == null) {
      classe = new Classe();
    }
    return classe;
  }

  public Views getView() {
    return view;
  }
}
