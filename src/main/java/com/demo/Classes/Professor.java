package com.demo.Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class  Professor extends Usuario {
  private static final String PATH_USUARIOS = "src/Arquivos/usuarios.csv";

  public Professor(String email, String senha, String tipo) {
    super(email, senha, tipo);
  }

}