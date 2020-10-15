package com.company;

import java.io.*;

public class CrearFicheroSintomas {

    //Nombres A guardar
    String[] listaNombres = {"Ataque al corazón", "Huesos perezosos", "Licantropía", "Fiebre nocturna",
            "crisis del mimo","Hinchazon de nariz","Quemaduras Cerebrales"};

    //Se Declara el archivo1
    File archivo = new File(".\\Archivos\\Enfermedades.txt");

    {
        try {
            // Se crea el flujo de datos salida
            FileWriter fw = new FileWriter(archivo);
            // Se crea El buffer
            PrintWriter pw = new PrintWriter(fw);
            for (String nombre : listaNombres) {
                pw.println(nombre + " ");
            }
            //cerramos el fichero
            pw.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
