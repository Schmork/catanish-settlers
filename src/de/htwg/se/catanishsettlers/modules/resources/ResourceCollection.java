package de.htwg.se.catanishsettlers.modules.resources;

/**
 * Created by Stephan on 04.04.2015.
 */
public class ResourceCollection {
    private Brick brick;
    private Lumber lumber;
    private Wool wool;
    private Grain grain;
    private Ore ore;

    public ResourceCollection(Resource... resources) {
        this(0);    // initializes fields
        for (Resource resource : resources) add(resource);
    }

    public ResourceCollection(int initialAmount) {
        brick = new Brick(initialAmount);
        lumber = new Lumber(initialAmount);
        wool = new Wool(initialAmount);
        grain = new Grain(initialAmount);
        ore = new Ore(initialAmount);
    }

    public Brick getBrick() {
        return brick;
    }

    public Lumber getLumber() {
        return lumber;
    }

    public Wool getWool() {
        return wool;
    }

    public Grain getGrain() {
        return grain;
    }

    public Ore getOre() {
        return ore;
    }

    private void add(Resource resource) {                       // logic to add a resource
        if (resource.getClass() == Brick.class) brick.add(resource);
        if (resource.getClass() == Lumber.class) lumber.add(resource);
        if (resource.getClass() == Wool.class) wool.add(resource);
        if (resource.getClass() == Grain.class) grain.add(resource);
        if (resource.getClass() == Ore.class) ore.add(resource);
    }

    private void subtract(Resource resource) {                  // logic to subtract a resource
        if (resource.getClass() == Brick.class) brick.subtract(resource);
        if (resource.getClass() == Lumber.class) lumber.subtract(resource);
        if (resource.getClass() == Wool.class) wool.subtract(resource);
        if (resource.getClass() == Grain.class) grain.subtract(resource);
        if (resource.getClass() == Ore.class) ore.subtract(resource);
    }

    private void add(ResourceCollection resources) {  // logic to add a collection
        brick.add(resources.brick);
        lumber.add(resources.lumber);
        wool.add(resources.wool);
        grain.add(resources.grain);
        ore.add(resources.ore);
    }

    private void subtract(ResourceCollection resources) {   // logic to subtract a collection
        brick.subtract(resources.brick);
        lumber.subtract(resources.lumber);
        wool.subtract(resources.wool);
        grain.subtract(resources.grain);
        ore.subtract(resources.ore);
    }

    public ResourceCollection add(Resource... resources) {                  // add resource(s)
        for (Resource resource : resources) add(resource);
        return this;
    }

    public ResourceCollection add(ResourceCollection... additions) {        // add collection(s)
        for (ResourceCollection resources : additions) add(resources);
        return this;
    }

    public ResourceCollection subtract(Resource... resources) {             // subtract resource(s)
        for (Resource resource : resources) subtract(resource);
        return this;
    }

    public ResourceCollection subtract(ResourceCollection... subtraction) {    // subtract collection(s)
        for (ResourceCollection resources : subtraction) subtract(resources);
        return this;
    }

    public boolean isPositive() {
        return (brick.isPositive() && lumber.isPositive() && wool.isPositive()
                && grain.isPositive() && ore.isPositive());
    }

    /**
     * returns 0 if equal in all resources
     * returns 1 if this > other in all resources
     * returns -1 if any one resource of this < other (which for example means, a cost cannot be payed)
     */
    public int compareTo(ResourceCollection other) {
        if (brick.getAmount() == other.brick.getAmount() &&
                lumber.getAmount() == other.lumber.getAmount() &&
                wool.getAmount() == other.wool.getAmount() &&
                grain.getAmount() == other.grain.getAmount() &&
                ore.getAmount() == other.ore.getAmount()) {
            return 0;
        } else if (brick.getAmount() < other.brick.getAmount() ||
                lumber.getAmount() < other.lumber.getAmount() ||
                wool.getAmount() < other.wool.getAmount() ||
                grain.getAmount() < other.grain.getAmount() ||
                ore.getAmount() < other.ore.getAmount()) {
            return -1;
        } else return 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Brick: ");
        sb.append(brick.getAmount());
        sb.append(System.lineSeparator());

        sb.append("Lumber: ");
        sb.append(lumber.getAmount());
        sb.append(System.lineSeparator());

        sb.append("Wool: ");
        sb.append(wool.getAmount());
        sb.append(System.lineSeparator());

        sb.append("Grain: ");
        sb.append(grain.getAmount());
        sb.append(System.lineSeparator());

        sb.append("Ore: ");
        sb.append(ore.getAmount());
        sb.append(System.lineSeparator());

        return sb.toString();
    }
}
