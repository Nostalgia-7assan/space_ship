public class U1 extends Rocket {
    public U1() {
        cost = 100; // in millions
        rocketWeight = 10000; // in Kg
        maxWeight = 18000; // in Kg
    }
    @Override
    public boolean launch() {
        float explosion = (float) (.05 * ((float)cargoWeight / (maxWeight-rocketWeight)));
        float randomNumber = (float) Math.random();
        if (randomNumber < explosion)
            return true;
        return false;
    }

    @Override
    public boolean land() {
        float crash = (float) (.01 * ((float)cargoWeight / (maxWeight-rocketWeight)));
        float randomNumber = (float) Math.random();
        if (randomNumber < crash)
            return true;
        return false;
    }
}
