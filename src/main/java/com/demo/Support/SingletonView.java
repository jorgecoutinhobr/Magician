package com.demo.Support;

public class SingletonView {
  private final ViewsManager view;
  private static SingletonView singletonView;

  private SingletonView() {
    this.view = new ViewsManager();
  }

  public static synchronized SingletonView getInstance() {
    if (singletonView == null) {
      singletonView = new SingletonView();
    }
    return singletonView;
  }

  public ViewsManager getView() {
    return view;
  }
}
