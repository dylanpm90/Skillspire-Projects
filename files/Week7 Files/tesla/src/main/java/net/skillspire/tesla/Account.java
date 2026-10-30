package net.skillspire.tesla;

// POINT: One Account object = one row of the accounts table, like Wednesday's Vehicle.
// ASK:   "We never write  new Account()  for the rows we read. Who does?"
//        (BeanPropertyRowMapper: new Account(), then the setters, matching columns by name.)

public class Account {
    private long id;
    private String owner;
    private double balance;   // double to match the Week 7 Worksheet; real banks use BigDecimal

    public Account() { }      // BeanPropertyRowMapper needs it

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}
