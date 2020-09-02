import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    public ArrayList<Item> loadItems(Scanner file) {
        ArrayList<Item> items = new ArrayList<Item>();
        while(file.hasNextLine())
        {
            String line = file.nextLine();
            String[] arr = line.split("=", 2);
            Item item = new Item(arr[0], Integer.parseInt(arr[1]));
            items.add(item);
        }
        return items;
    }

    public ArrayList<U1> loadU1(ArrayList<Item> items) {
        ArrayList<U1> fleet = new ArrayList<>();
        U1 rocket = new U1();
        for(Item item : items)
        {
           if(rocket.canCarry(item))
               rocket.carry(item);
           else {
               fleet.add(rocket);
               rocket = new U1();
               rocket.carry(item);
           }
        }
        fleet.add(rocket);
        return fleet;
    }

    public ArrayList<U2> loadU2(ArrayList<Item> items) {
        ArrayList<U2> fleet = new ArrayList<>();
        U2 rocket = new U2();
        for(Item item : items)
        {
            if(rocket.canCarry(item))
                rocket.carry(item);
            else {
                fleet.add(rocket);
                rocket = new U2();
                rocket.carry(item);
            }
        }
        fleet.add(rocket);
        return fleet;
    }

    public int runSimulation(ArrayList<Rocket> rockets) {
        int cost = 0 ;
        for(Rocket rocket : rockets)
        {
            while(true) {
                cost += rocket.getCost();
                if(rocket.launch() && rocket.land())
                    break;
            }
        }
        return cost;
    }

}
