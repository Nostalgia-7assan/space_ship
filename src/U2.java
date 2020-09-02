public class U2 extends Rocket {
    public U2() {
        cost = 120; // in millions
        rocketWeight = 18000; // in Kg
        maxWeight = 29000; // in Kg
    }
    @Override
    public boolean launch() {
        float explosion = (float) (.04 * ((float)cargoWeight / (maxWeight-rocketWeight)));
        float randomNumber = (float) Math.random();
        if (randomNumber < explosion)
            return true;
        return false;
    }

    @Override
    public boolean land() {
        float crash = (float) (.08 * ((float)cargoWeight / (maxWeight-rocketWeight)));
        float randomNumber = (float) Math.random();
        if (randomNumber < crash)
            return true;
        return false;
    }
}
