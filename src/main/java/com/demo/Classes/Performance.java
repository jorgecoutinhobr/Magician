package com.demo.Classes;

import java.util.ArrayList;

public class Performance {
    private String email;
    private static int respCertas;
    private static int respTotais;

    public static void addResposta(String email, boolean certa) {
        ArrayList<String> list = Busca.performance(email);
        respCertas = Integer.parseInt(list.get(1));
        respTotais = Integer.parseInt(list.get(2));
        respTotais++;
        if(certa) respCertas++;
        list.add(1, String.valueOf(respCertas));
        list.add(2, String.valueOf(respTotais));
        //append list em performance.csv (sobrescrever)
    }

}
