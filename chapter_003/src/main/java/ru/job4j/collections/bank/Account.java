package ru.job4j.collections.bank;

/**
 * Class Account.
 *
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 14.11.2018.
 */

public class Account {
    private double values;
    private String requisites;

    public Account(double values, String requisites) {
        this.values = values;
        this.requisites = requisites;
    }

    public double getValues() {
        return values;
    }

    public void setValues(double values) {
        this.values = values;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        if (Double.compare(account.values, values) != 0) {
            return false;
        }
        return requisites != null ? requisites.equals(account.requisites) : account.requisites == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(values);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (requisites != null ? requisites.hashCode() : 0);
        return result;
    }

    public boolean transfer(Account destAccount, double amount) {
        boolean success = false;
        if (amount > 0 && amount < this.values && destAccount != null) {
            success = true;
            this.values -= amount;
            destAccount.values += amount;
        }
        return success;
    }
}
