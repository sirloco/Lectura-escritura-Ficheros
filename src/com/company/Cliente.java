package com.company;
import java.io.Serializable;
import java.util.List;

public class Cliente implements Serializable {

  private final String[] clientes;

  public Cliente(String[] clientes) {
    this.clientes = clientes;
  }

  public String[] getClientes() {
    return clientes;
  }
}
