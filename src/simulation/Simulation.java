package simulation;

import java.util.ArrayList;

import data.DailyReport;
import electricity.Consumer;
import electricity.Device;
import electricity.ElecEntity;
import electricity.PowerPlant;

public class Simulation {
	private ArrayList<Consumer> consumerlist;
	private ArrayList<PowerPlant> plantlist;

	private ArrayList<Device> deviceList = new ArrayList<Device>();

	public Simulation() {
		this.consumerlist = new ArrayList<Consumer>();
		this.plantlist = new ArrayList<PowerPlant>();
	}

	public Simulation(ArrayList<Consumer> consumerlist, ArrayList<PowerPlant> plantlist) {
		this.consumerlist = consumerlist;
		this.plantlist = plantlist;
	}

	public void addConsumer(Consumer cons) {
		this.consumerlist.add(cons);
	}

	public void addPlant(PowerPlant plant) {
		this.plantlist.add(plant);
	}

	public void createDeviceList() {
		for (Consumer cons : consumerlist) {
			for (Device dev : cons.getDevicelist()) {
				this.deviceList.add(dev);
			}
		}
	}

	public DailyReport simulateDay(int i) {
		this.createDeviceList();
		DailyReport dRep = new DailyReport(i);
		double yearPow;
		int consoMinute;
		for (ElecEntity ent : this.deviceList) {
			yearPow = ent.getPowerYear(i) / 100;
			for (int minute = 0; minute < 1440; minute++) {
				consoMinute = ent.getConsoMinute(minute);
				dRep.addMinuteConso(minute, consoMinute / 100 * yearPow);
			}
		}
		for (ElecEntity ent : this.plantlist) {
			yearPow = ent.getPowerYear(i) / 100;
			for (int minute = 0; minute < 1440; minute++) {
				consoMinute = ent.getConsoMinute(minute);
				dRep.addMinuteProd(minute, consoMinute / 100 * yearPow);
			}
		}
		return dRep;
	}

}
