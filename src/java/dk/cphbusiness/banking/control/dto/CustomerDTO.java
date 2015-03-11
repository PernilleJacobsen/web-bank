package dk.cphbusiness.banking.control.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable {
  private final int id;
  private final String name;
  private final int total;

  public CustomerDTO(int id, String name, int total) {
    this.id = id;
    this.name = name;
    this.total = total;
    }

  public int getId() {
    return id;
    }

  public String getName() {
    return name;
    }

  public int getTotal() {
    return total;
    }
  
  }
