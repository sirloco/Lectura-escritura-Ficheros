package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Incidencias {

    public static void compruebaIncidencias(List<Comanda> comandas, Cliente cliente) {

        List<String> enfermedades = new ArrayList<>();

        int clientes =0;
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
        for (int i = 0; i < cliente.getClientes()[0].length; i++) {

            //recorremos las comandas en busca de ese cliente
            for (Comanda comanda : comandas) {

                if (comanda.getCliente().equals(cliente.getClientes()[0][i])) {

                    if (cliente.getClientes()[1][i].equals(comanda.getPrimero())){
                        System.out.println(cliente.getClientes()[0][i] +" contagio en el primero");
                    }

                    if (cliente.getClientes()[1][i].equals(comanda.getSegundo())) {
                        System.out.println(cliente.getClientes()[0][i]+ " contagio en el segundo");
                    }

                    if (cliente.getClientes()[1][i].equals(comanda.getPostre())) {
                        System.out.println(cliente.getClientes()[0][i]+ " contagio en el postre");
                    }

                }
            }

            System.out.println(cliente.getClientes()[1][i]);
        }

        //enfermedad en gallego se escribe enfermedade
        for (String enfermedade : enfermedades) {


        }

    }

}
