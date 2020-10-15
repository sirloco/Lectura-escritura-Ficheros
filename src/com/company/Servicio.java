package com.company;

import org.w3c.dom.*;

import javax.xml.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Servicio {

    public static void nuevoServicio() {
        {

            List<Comanda> comandas = new ArrayList<>();

            try {

                //Creamos el flujo de entrada del archivo clientes
                ObjectInputStream finClientes = new ObjectInputStream(new FileInputStream(".\\Archivos\\Clientes.dat"));

                //Creamos el flujo de entrada del archivo menu
                ObjectInputStream finMenu = new ObjectInputStream(new FileInputStream(".\\Archivos\\Menu.dat"));

                //Sacamos el objeto que contiene la lista de clientes
                Cliente cli = (Cliente) finClientes.readObject();

                //Sacamos el objeto que contiene las listas de los platos
                Menu menu = (Menu) finMenu.readObject();

                //Como es bidimensional hay que poner el [1]
                for (int i = 0; i < cli.getClientes()[1].length; i++) {

                    String primero = plato(menu, 1);
                    String segundo = plato(menu, 2);
                    String postre = plato(menu, 3);

                    comandas.add(new Comanda(cli.getClientes()[0][i], primero, segundo, postre));

                }

                //todo esto acordarse de borrarlo
                for (Comanda comanda : comandas) {
                    System.out.println(comanda.getCliente() + " ha comido " + comanda.getPrimero() + " de primero " +
                            comanda.getSegundo() + " de segundo " + comanda.getPostre() + " de postre");
                }

                creaXml(comandas);

            } catch (IOException | ClassNotFoundException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    /**
     * Genera platos aleatorios para cada cliente
     *
     * @param m         Objeto que contiene la lista de los platos
     * @param categoria numero para especificar si son primero 1 segundos 2 o postres 3
     */
    public static String plato(Menu m, int categoria) {
        String plato;
        int nplatos = 5;

        Random rand = new Random();

        int nAleatorio = rand.nextInt(nplatos);

        switch (categoria) {

            case 1:
                plato = m.getPrimeros()[nAleatorio];
                break;

            case 2:
                plato = m.getSegundos()[nAleatorio];
                break;

            case 3:
                plato = m.getPostres()[nAleatorio];
                break;

            default:
                plato = "";

        }

        return plato;
    }

    /**
     * Crea el fichero XML
     */
    public static void creaXml(List<Comanda> comandas) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Comandas", null);
            document.setXmlVersion("1.0");

            for (Comanda comanda : comandas) {

                //Crea y añade el nodo
                Element raiz = document.createElement("Cliente"); //nodo cliente

                document.getDocumentElement().appendChild(raiz); //lo añade a la raíz del documento

                //se añaden los hijos al nodo raiz
                CrearElemento("Nombre", comanda.getCliente(), raiz, document);
                CrearElemento("Primero", comanda.getPrimero(), raiz, document);
                CrearElemento("Segundo", comanda.getSegundo(), raiz, document);
                CrearElemento("Postre", comanda.getPostre(), raiz, document);

            }


            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File(".\\Archivos\\Empleados.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            //Result console = new StreamResult(System.out);
            //transformer.transform(source, console);

        } catch (ParserConfigurationException | TransformerConfigurationException ignored) {
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }


    static void CrearElemento(String datoEmple, String valor, Element raiz, Document document) {
        Element elem = document.createElement(datoEmple); //creamos hijo
        Text text = document.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor
    }
}
