package dk.cphbusiness.banking.model;

import java.util.Date;

public class Movement implements Comparable<Movement> {
  private final Date time;
  private final int amount;
  private final Account source;
  private final Account target;
  
  public Movement(Date time, int amount, Account source, Account target) {
    this.time = time;
    this.amount = amount;
    this.source = source;
    this.target = target;
    }

  public Date getTime() {
    return time;
    }

  public int getAmount() {
    return amount;
    }

  public Account getSource() {
    return source;
    }

  public Account getTarget() {
    return target;
    }

  @Override
  public int compareTo(Movement other) {
    return this.time.compareTo(other.time);
    }
  
  }
