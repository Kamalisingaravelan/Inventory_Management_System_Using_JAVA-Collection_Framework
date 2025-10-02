package org.anp.inventory.Model;

public class Saving {
    private double amount;

    public Saving() {
        this.amount = 0;
    }

    public double getAmount() { return amount; }
    public void addAmount(double amount) { this.amount += amount; }

    @Override
    public String toString() {
        return "Savings [amount=" + amount + "]";
    }
}
