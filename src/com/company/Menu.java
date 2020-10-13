package com.company;

import java.io.Serializable;

public class Menu implements Serializable {

    private final String[] primeros;
    private final String[] segundos;
    private final String[] postres;

    public Menu(String[] pri, String[] seg, String[] pos) {
        primeros = pri;
        segundos = seg;
        postres = pos;
    }

    public String[] getPrimeros() {
        return primeros;
    }
    public String[] getSegundos() {
        return segundos;
    }
    public String[] getPostres() {
        return postres;
    }
}
