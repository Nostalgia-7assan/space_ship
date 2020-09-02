import java.util.ArrayList;

public class Rocket implements SpaceShip {

    protected ArrayList<Item> items;
    protected int cargoWeight ;
    protected int rocketWeight;
    protected int maxWeight ;
    protected int cost;
    protected float launchChance;
    protected float landChance;

    public Rocket() {
        cargoWeight = 0 ;
        items = new ArrayList<Item>();
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        int currentWeight = cargoWeight + rocketWeight + item.weight ;
        if(currentWeight <= maxWeight)
            return true;
        return false;
    }

    @Override
    public void carry(Item item) {
        items.add(item);
        cargoWeight+= item.weight;
    }

    public int getCost() {
        return cost;
    }
}
