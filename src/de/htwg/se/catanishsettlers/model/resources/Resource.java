package de.htwg.se.catanishsettlers.model.resources;

/**
 * Created by Stephan on 04.04.2015.
 */
public abstract class Resource {
    private int amount;

    public Resource() {
        amount = 0;
    }

    public Resource(int startAmount) {
        amount = startAmount;
    }

    public int getAmount() {
        return amount;
    }

    public Resource add(int addition) {
        amount += addition;
        return this;
    }

    public Resource add(Resource addition) {
        if (!checkIfSameType(addition))
            throw new IllegalArgumentException("not the same resource type");
        return add(addition.getAmount());
    }

    public Resource subtract(int subtraction) {
        amount -= subtraction;
        return this;
    }

    public Resource subtract(Resource subtraction) {
        if (!checkIfSameType(subtraction))
            throw new IllegalArgumentException("not the same resource type");
        return subtract(subtraction.getAmount());
    }

    public boolean isPositive() {
        return amount >= 0;
    }

    private boolean checkIfSameType(Resource proband) {
        return this.getClass().equals(proband.getClass());
    }

    public String toString() {
        return this.getClass().getSimpleName() + "(" + amount + ")";
    }
}
