package com.company;

import java.io.*;

public class CrearFicheroClientes {

    String[][] clientes = {{"Iñaki", "Santi", "Erlantz", "Oscar", "Sergio", "Blanca", "Ainhoa"},
            {"sopa de ajo", "tarta de queso", "Paella de marisco", "Lubina al horno", "Flan", "sopa de ajo", "Pulbo a Feira"}};

    //Se Declara el archivo Objetos
    File cliente = new File(".\\Archivos\\Clientes.dat");

    {
        try {

            //Se crea el flujo de datos Salida
            FileOutputStream fo = new FileOutputStream(cliente);

            //Escribimos en Objetos
            ObjectOutputStream oos = new ObjectOutputStream(fo);

            for (int i = 0; i < clientes.length; i++) {
                oos.writeObject(new Cliente(clientes));
            }

            //cerramos el fichero
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    {
        try {
            ObjectInputStream fin = new ObjectInputStream(new FileInputStream(".\\Archivos\\Clientes.dat"));

            Cliente cli = (Cliente) fin.readObject();

        } catch (IOException | ClassNotFoundException ioException) {
            ioException.printStackTrace();
        }
    }

}
