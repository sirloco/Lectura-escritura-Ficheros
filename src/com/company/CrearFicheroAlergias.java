package com.company;

import java.io.*;

public class CrearFicheroAlergias {

  //Nombres A guardar
  String[] listaNombres = {"Hinchazon de Nariz", "Ego Inflado", "Fiebre Nocturna", "Licantropía", "Diarrea Verbal", "cara Rota"};
  //Se Declara el archivo1
  File archivo = new File(".\\Archivos\\Enfermedades.txt");

  {
    try {

      //Se crea el flujo de datos salida
      FileWriter fw = null;

      fw = new FileWriter(archivo);
      //Se crea El buffer

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
