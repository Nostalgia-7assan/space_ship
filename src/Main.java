import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // load Items
        Simulation mySimulation = new Simulation();
        Scanner phase1File = new Scanner(new File("Phase-1.txt"));
        Scanner phase2File = new Scanner(new File("Phase-2.txt"));
        ArrayList phase1 = mySimulation.loadItems(phase1File);
        ArrayList phase2 = mySimulation.loadItems(phase2File);
        ArrayList fleet;

        // Simulation for U1
        int u1Cost = 0;
        for(int i = 0; i < 500; i++) {
            fleet = mySimulation.loadU1(phase1);
            u1Cost += mySimulation.runSimulation(fleet);
            fleet = mySimulation.loadU1(phase2);
            u1Cost += mySimulation.runSimulation(fleet);
        }
        System.out.println("U1 Cost = " + u1Cost/500 + " millions");

        // Simulation for U2
        int u2Cost = 0;
        for(int i = 0; i < 500; i++) {
            fleet = mySimulation.loadU2(phase1);
            u2Cost += mySimulation.runSimulation(fleet);
            fleet = mySimulation.loadU2(phase2);
            u2Cost += mySimulation.runSimulation(fleet);
        }
        System.out.println("U2 Cost = " + u2Cost/500 + " millions");
    }
}
