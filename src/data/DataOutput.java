package data;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import simulation.Simulation;

abstract public class DataOutput {

	public static void createDaily(int day, DailyReport dRep, AnnualReport anRep) throws FileNotFoundException {
		String outFile = "";
		PrintWriter out;
		outFile = "out/Daily-Report-number-" + day + ".csv";
		out = new PrintWriter(outFile);
		out.print(dRep);
		out.close();
		anRep.setdRepList(dRep, day);
	}

	public static void createAnnual(AnnualReport anRep) throws FileNotFoundException {
		String outFile = "";
		PrintWriter out;
		outFile = "out/Annual-Report.csv";
		out = new PrintWriter(outFile);
		out.print(anRep);
		out.close();
	}

	public void printCSV(Simulation sim) {

	}
}
