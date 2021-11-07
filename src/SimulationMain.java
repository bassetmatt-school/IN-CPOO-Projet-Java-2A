import java.io.FileNotFoundException;
import java.io.PrintWriter;

import electricity.inhabitants.Family;
import electricity.plants.Nuclear;


public class SimulationMain {
    public static void main(String[] args) throws FileNotFoundException {
        DailyReport dRep;
        Simulation sim = new Simulation();
        sim.addConsumer(new Family());
        sim.addPlant(new Nuclear());
        dRep = sim.simulateDay(0);
        //System.out.println(dRep);

        PrintWriter out = new PrintWriter("out.csv");
        out.println(dRep);
        out.close();
    }
}