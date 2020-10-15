package com.company;

import java.io.*;

public class CrearFicheroMenu {
  String[] primeros = {"Paella de marisco", "Enmsaladilla rusa", "menestra de verduras", "sopa de ajo", "Lentejas"};
  String[] segundos = {"Filete de ternera", "Lubina al horno", "Risoto con setas", "Pulbo a Feira", "cachopo"};
  String[] postres = {"Fruta del dia", "tarta de queso", "Goxua", "Flan", "Helado"};

  //Se Declara el archivo Objetos
  File menu = new File(".\\Archivos\\Menu.dat");

  {
    try {
      //Se crea el flujo de datos Salida
      FileOutputStream fo = new FileOutputStream(menu);
      //Escribimos en Objetos
      ObjectOutputStream oos = new ObjectOutputStream(fo);
      for (int i = 0; i < primeros.length; i++) {
        oos.writeObject(new Menu(primeros, segundos, postres));
      }
      //cerramos el fichero
      oos.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  {
    /*try {
      ObjectInputStream fin = new ObjectInputStream(new FileInputStream(".\\Archivos\\Menu.dat"));
      Menu menu = (Menu) fin.readObject();
      for (String primeros : menu.getPrimeros()) {
        System.out.println(primeros);
      }

    } catch (IOException | ClassNotFoundException ioException) {
      ioException.printStackTrace();
    }*/
  }

}
