package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Incidencias {

  public static void compruebaIncidencias(List<Comanda> comandas, Cliente cliente) {

    List<String> enfermedades = new ArrayList<>();

    int client = 0;
    int plato = 1;

    //Se Declara el archivo1
    File archivo = new File(".\\Archivos\\Enfermedades.txt");

    try {
      //Se crea el flujo de datos salida
      FileReader fr = new FileReader(archivo);
      //Se crea El buffer
      BufferedReader bf = new BufferedReader(fr);
      //Lee linea a linea hasta el final del archivo
      String linea = "";
      while (linea != null) {
        linea = bf.readLine();
        if (linea != null)
          enfermedades.add(linea);
      }
      //cerramos el fichero
      bf.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    //recorremos la lista de clientes
    for (int i = 0; i < cliente.getClientes()[client].length; i++) {

      //recorremos las comandas en busca de ese cliente
      for (Comanda comanda : comandas) {

        if (comanda.getCliente().equals(cliente.getClientes()[client][i])) {

          String platoMalo = cliente.getClientes()[plato][i];
          String comensal = cliente.getClientes()[client][i];

          //al encontrar el cliente se coteja su platno enemigo con el que ha pedido en la comanda
          if (platoMalo.equals(comanda.getPrimero())) {
            System.out.println(comensal + " ha comido " + platoMalo + "  y le ha provocado: " + enfermedades.get(i));
          }
          //lo mismo con el segundo plato
          if (platoMalo.equals(comanda.getSegundo())) {
            System.out.println(comensal + " ha comido " + platoMalo + "  y le ha provocado: " + enfermedades.get(i));
          }
          //lo mismo con el postre
          if (platoMalo.equals(comanda.getPostre())) {
            System.out.println(comensal + " ha comido " + platoMalo + "  y le ha provocado: " + enfermedades.get(i));
          }

        }
      }

    }

  }

}
