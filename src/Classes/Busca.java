package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Busca {
    private Busca(){}
    public static ArrayList<String> pergunta(int nivel){
        final String PATH_PERGUNTAS = "src/Arquivos/Perguntas/nivel" + String.valueOf(nivel) +  ".csv";
        ArrayList<String> resultado = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH_PERGUNTAS))) {
            String linha;
            int codigo = (int) (Math.random() * tamanhoArquivo(PATH_PERGUNTAS) + 1);
            while ((linha = reader.readLine())!= null) {
                String[] campos = linha.split(";");
                if (Integer.parseInt(campos[campos.length-1]) == codigo) {
                    resultado.addAll(Arrays.asList(campos));
                    return resultado;
                }
            }
            if(resultado.size() == 0){
                throw(new Exception("Não existem perguntas desse nivel."));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static ArrayList<String> usuario(String email){
        final String PATH_USUARIOS = "src/Arquivos/usuarios.csv";
        ArrayList<String> resultado = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH_USUARIOS))) {
            String linha;
            while ((linha = reader.readLine())!= null) {
                String[] campos = linha.split(",");
                if (campos.length >= 2 && campos[0].equals(email)) {
                    resultado.addAll(Arrays.asList(campos));
                    return resultado;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static int tamanhoArquivo(String PATH){
        int tamanho = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String linha;
            while ((linha = reader.readLine())!= null) {
                tamanho++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tamanho;
    }
}


