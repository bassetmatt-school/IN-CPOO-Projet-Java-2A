package simulation;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import data.DataOutput;
import data.AnnualReport;
import data.DailyReport;
import electricity.inhabitants.Family;
import electricity.plants.Nuclear;


public class SimulationMain {
	public static void main(String[] args) throws FileNotFoundException {
		DailyReport dRep;
		AnnualReport anRep = new AnnualReport();
		
		Simulation sim = new Simulation();
    	sim.addConsumer(new Family());
    	sim.addPlant(new Nuclear());
		for (int day = 0; day < 365; day++) {
			dRep = sim.simulateDay(day);
			DataOutput.createDaily(day, dRep, anRep);	
		}
		DataOutput.createAnnual(anRep);
	}
}