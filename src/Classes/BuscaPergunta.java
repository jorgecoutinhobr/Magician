package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class BuscaPergunta {
    private static final String PATH_PERGUNTAS = "src/Arquivos/perguntas.csv";

    public static ArrayList<String> busca(int nivel){
        ArrayList<String> resultado = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH_PERGUNTAS))) {
            String linha;
            while ((linha = reader.readLine())!= null) {
                String[] campos = linha.split(";");
                if (Integer.parseInt(campos[campos.length-1]) == nivel) {
                    resultado.addAll(Arrays.asList(campos));
                    return resultado;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }



    public static void perguntaFormatada(ArrayList<String> perguntas){
        System.out.println("Questão de nível: " + perguntas.getLast() + "\n\n" +perguntas.getFirst() + "\n\n" + perguntas.get(1) + "\n");
        for (int i = 2; i < (perguntas.size()-2); i++) {
            System.out.println(perguntas.get(i));
        }
    }






}