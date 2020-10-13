package com.company;
import java.io.Serializable;
public class Comanda implements Serializable {

  private String cliente;
  private String primero;
  private String segundo;
  private String postre;

  public Comanda(String cliente, String primero, String segundo, String postre) {
    this.cliente = cliente;
    this.primero = primero;
    this.segundo = segundo;
    this.postre = postre;
  }

  public String getCliente() {
    return cliente;
  }
  public void setCliente(String cliente) {
    this.cliente = cliente;
  }
  public String getPrimero() {
    return primero;
  }
  public void setPrimero(String primero) {
    this.primero = primero;
  }
  public String getSegundo() {
    return segundo;
  }
  public void setSegundo(String segundo) {
    this.segundo = segundo;
  }
  public String getPostre() {
    return postre;
  }
  public void setPostre(String postre) {
    this.postre = postre;
  }
}
