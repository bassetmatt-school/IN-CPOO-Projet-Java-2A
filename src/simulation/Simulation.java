package simulation;

import java.io.IOException;
import java.util.ArrayList;

import data.AnnualReport;
import data.DailyReport;
import data.DataOutput;
import electricity.Consumer;
import electricity.Device;
import electricity.EntitiesGenerator;
import electricity.PowerPlant;

abstract public class Simulation {
	private static ArrayList<Consumer> cityPeople;
	private static ArrayList<PowerPlant> cityPlants;
	private static ArrayList<Device> deviceList;
	private static ArrayList<PowerPlant> plantList;


	
	
	private static void setDeviceList() {
		ArrayList<Device> deviceList = new ArrayList<Device>();
		for (Consumer cons : cityPeople) {
			for (Device dev : cons.getDeviceList()) {
				deviceList.add(dev);
			}
		}
		Simulation.deviceList = deviceList;
	}
	
	private static void setPlantList() {
		ArrayList<PowerPlant> plantList = new ArrayList<PowerPlant>();
		for (PowerPlant plt : cityPlants) {
			plantList.add(plt);
		}
		Simulation.plantList = plantList;
	}

	public static void initSimulation() throws IllegalArgumentException, IOException {
		EntitiesGenerator.generateCity();
		cityPeople = EntitiesGenerator.getCityPeople();
		cityPlants = EntitiesGenerator.getCityPlants();
		setDeviceList();
		setPlantList();
	}
	
	public static DailyReport generateDailyReport(int day) {
		double[] conso = new double[1440];
		double[] prod = new double[1440];
		for (Device dev : deviceList) {
			conso = dev.computeConsoDay(day, conso, dev.getPower());
		}
		for (PowerPlant plt : plantList) {
			prod = plt.computeConsoDay(day, prod, plt.getPower());
		}
		return new DailyReport(day, conso, prod);	
	}

	public static void main(String[] args) throws IllegalArgumentException, IOException {
		initSimulation();
		AnnualReport anRep = new AnnualReport();
		DailyReport dRep;
		for (int day=0; day<365;day++) {
			dRep = generateDailyReport(day);
			DataOutput.createDaily(day, dRep, anRep);
			DataOutput.createAnnual(anRep);
		}

	}

}
