package electricity;

import utilitary.schedules.Schedule;
import utilitary.schedules.SchedulePart;

abstract public class ElecEntity {
	private double power;
	private Schedule schedule;

	public ElecEntity(double power) {
		this.power = power;
		this.schedule = new Schedule();
	}

	public ElecEntity(double power, Schedule schedule) {
		this.power = power;
		this.schedule = schedule;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

	public int getConsoMinute(int i) throws IllegalArgumentException {
		for (SchedulePart sp : this.getSchedule().getDaySchedule()) {
			if (i < sp.getDurationCum()) {
				return sp.getConso();
			}
		}
		throw new IllegalArgumentException("Your index must be inferior to 1440");
	}

	public double getPowerYear(int i) throws IllegalArgumentException {
		for (SchedulePart sp : this.getSchedule().getYearSchedule()) {
			if (i < sp.getDurationCum()) {
				return sp.getConso() * this.getPower();
			}
		}
		throw new IllegalArgumentException("Your index must be inferior to 365");
	}

	@Override
	public String toString() {
		return "{" + " power='" + getPower() + "'" + ", schedule='" + getSchedule() + "'" + "}";
	}

}
