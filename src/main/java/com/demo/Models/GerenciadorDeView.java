package com.demo.Models;

import com.demo.Views.Views;

public class GerenciadorDeView {
  private final Views view;
  private static GerenciadorDeView gerenciadorDeView;

  private GerenciadorDeView() {
    this.view = new Views();
  }

  public static synchronized GerenciadorDeView getInstance() {
    if (gerenciadorDeView == null) {
      gerenciadorDeView = new GerenciadorDeView();
    }
    return gerenciadorDeView;
  }

  public Views getView() {
    return view;
  }
}
