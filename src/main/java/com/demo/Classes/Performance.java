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

    public static String showNivel(String email) {
        ArrayList<String> list = Busca.usuario(email);
        assert list != null;
        switch (list.get(3)) {
            case "2":
                return "Intermediário";
            case "3":
                return "Avançado";
            case "4":
                return "Fluente";
            case "1":
                return "Iniciante";
            default:
                return null;
        }
    }

}
