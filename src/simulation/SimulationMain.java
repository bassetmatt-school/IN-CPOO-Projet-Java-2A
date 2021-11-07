package simulation;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import dataout.AnnualReport;
import dataout.DailyReport;
import electricity.inhabitants.Family;
import electricity.plants.Nuclear;


public class SimulationMain {
    public static void main(String[] args) throws FileNotFoundException {
        DailyReport[] dRepList = new DailyReport[365];
        Simulation sim = new Simulation();
        sim.addConsumer(new Family());
        sim.addPlant(new Nuclear());
        String outFile = "";
        PrintWriter out;
        for (int day = 0; day < 365; day++) {
            dRepList[day] = sim.simulateDay(day);
            outFile = "out/Daily-Report-number-" + (day+1) + ".csv";
            out = new PrintWriter(outFile);
            out.print(dRepList[day]);
            out.close();
        }
        AnnualReport anRep = new AnnualReport();
        anRep.complete(dRepList);
        outFile = "out/Annual-Report.csv";
        out = new PrintWriter(outFile);
        out.print(anRep);
        out.close();

    }
}