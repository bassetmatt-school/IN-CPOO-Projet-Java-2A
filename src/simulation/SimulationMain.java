package simulation;

import java.io.IOException;

import data.AnnualReport;
import data.DailyReport;
import data.DataOutput;

public class SimulationMain {
	public static void main(String[] args) throws IllegalArgumentException, IOException {
		Simulation.initSimulation();
		AnnualReport anRep = new AnnualReport();
		DailyReport dRep;
		for (int day = 0; day < 365; day++) {
			dRep = Simulation.generateDailyReport(day);
			DataOutput.createDaily(day, dRep, anRep);
			DataOutput.createAnnual(anRep);
		}
	}
}