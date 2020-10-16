package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Incidencias {

    public static void compruebaIncidencias(List<Comanda> comandas, Cliente cliente) {

        List<String> enfermedades = new ArrayList<>();

        int client = 0;
        int plato = 1;

        //Se Declara el archivo de las enfermedades para tenerlas
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


        //Se Declara el archivo incidencias para guardar las incidencias ocurridas
        File incidencias = new File(".\\Archivos\\Incidencias.txt");

        {
            try {
                // Se crea el flujo de datos salida
                FileWriter fw = new FileWriter(incidencias);

                // Se crea El buffer
                PrintWriter pw = new PrintWriter(fw);

                //recorremos la lista de clientes
                for (int i = 0; i < cliente.getClientes()[client].length; i++) {

                    //recorremos las comandas en busca de ese cliente
                    for (Comanda comanda : comandas) {

                        if (comanda.getCliente().equals(cliente.getClientes()[client][i])) {

                            String platoMalo = cliente.getClientes()[plato][i];
                            String comensal = cliente.getClientes()[client][i];
                            String mensaje = comensal + " ha comido " + platoMalo + "  y le ha provocado: " + enfermedades.get(i);
                            boolean alarma = false;

                            //al encontrar el cliente se coteja su platno enemigo con el que ha pedido en la comanda
                            if (platoMalo.equals(comanda.getPrimero()) ||
                                    platoMalo.equals(comanda.getSegundo()) ||
                                    platoMalo.equals(comanda.getPostre()))
                                alarma = true;

                            if (alarma) {
                                pw.println(mensaje);
                                System.out.println(mensaje);
                            }

                        }//Fin de l if que comprueba si el cliente ha pedido algo
                    }//Fin de lfor que recorre las comandas en busca del cliente
                }//Fin del for que recorre la lista de clientes

                //cerramos el fichero
                pw.close();
            } catch (
                    IOException e) {
                e.printStackTrace();
            }
        }//Fin del try que intenta escribir en el fichero
    }//Fin de la funcion que busca las incidencias del servicio
}
