package com.demo.Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class  Professor {
  private static final String PATH_USUARIOS = "src/Arquivos/usuarios.csv";
  private String email;
  private String senha;

  public Professor(String email, String senha) {
    this.email = email;
    this.senha = senha;
  }

  public String getEmail() {
    return email;
  }

  public String getSenha(){
    return senha;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }
}