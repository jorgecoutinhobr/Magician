package com.demo.Classes;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Performance {
    private static String emailAluno;
    private static int respCertas;
    private static int respTotais;
    private static String pergungtasRespondidas;

    public static void addResposta(String email, boolean certa, String idpergunta) {
        ArrayList<String> performancelist = Busca.performance(email);
        String teste;
        emailAluno = performancelist.getFirst();
        respCertas = Integer.parseInt(performancelist.get(1));
        respTotais = Integer.parseInt(performancelist.get(2));
        pergungtasRespondidas = performancelist.getLast();
        pergungtasRespondidas = pergungtasRespondidas.substring(0,performancelist.size()) + ";" + idpergunta + "]";
        System.out.println(pergungtasRespondidas);
        respTotais++;
        if(certa) respCertas++;
        teste = emailAluno +
                "," + String.valueOf(respCertas) +
                "," + String.valueOf(respTotais) +
                "," + pergungtasRespondidas;
        performancelist.clear();
        performancelist.add(emailAluno);
        performancelist.add(String.valueOf(respCertas));
        performancelist.add(String.valueOf(respTotais));
        performancelist.add(pergungtasRespondidas);
        System.out.println(teste);
        salvaPerformance(teste,performancelist.getFirst());
        //append list em performance.csv (sobrescrever)
    }

    private static void salvaPerformance(String performancelist, String email){
        final String PATH_PERFORMANCE = "src/main/java/com/demo/Database/performance.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH_PERFORMANCE));
             BufferedWriter writer = new BufferedWriter(new FileWriter(PATH_PERFORMANCE))) {
            String linha;
            int linhan = 1;
            while ((linha = reader.readLine())!= null) {
                String[] campos = linha.split(",");
                if (campos[0].equals(email)) {
                    writer.write(performancelist);
                    System.out.println(linhan);
                    System.out.println("bla");
                    break;
                }
                linhan++;
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
