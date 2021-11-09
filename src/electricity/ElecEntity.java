package electricity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import utilitary.schedules.Schedule;
import utilitary.schedules.ScheduleGenerator;
import utilitary.schedules.SchedulePart;

abstract public class ElecEntity {
	private ArrayList<SchedulePart> scheduleDay;
	private ArrayList<SchedulePart> scheduleYear;
	private double power;
	private int hSch;
	private int wSch;
	private int mSch;

	public ElecEntity(double power, int hSch, int wSch, int mSch) throws IOException {
		this.power = power;
		this.hSch = hSch;
		this.wSch = wSch;
		this.mSch = mSch;
		Schedule schedule = ScheduleGenerator.generateSchedule(hSch, wSch, mSch);
		this.scheduleDay = schedule.getDaySchedule();
		this.scheduleYear = schedule.getYearSchedule();
	}

	public ElecEntity(int[] inputArray) throws IOException {
		this.power = (double) inputArray[0];
		this.hSch = inputArray[1];
		this.wSch = inputArray[2];
		this.mSch = inputArray[3];
		setSchedule();
	}

	public ArrayList<SchedulePart> getscheduleDay() {
		return scheduleDay;
	}

	public ArrayList<SchedulePart> getscheduleYear() {
		return scheduleYear;
	}

	public double getPower() {
		return power;
	}

	public double gethSch() {
		return hSch;
	}

	public double getwSch() {
		return wSch;
	}

	public double getmSch() {
		return mSch;
	}

	public Schedule getSchedule() {
		return new Schedule(scheduleYear, scheduleDay);
	}

	public void setPower(double power) {
		this.power = power;
	}

	public void setSchedule() throws IOException {
		Schedule schedule = ScheduleGenerator.generateSchedule(hSch, wSch, mSch);
		this.scheduleDay = schedule.getDaySchedule();
		this.scheduleYear = schedule.getYearSchedule();
	}

	public void setScheduleIds(int hSch, int wSch, int mSch) {
		this.hSch = hSch;
		this.wSch = wSch;
		this.mSch = mSch;
	}

	public double[] computeConsoDay(int day, double[] currentconso, double power) {
		int count;
		int i = 0;
		double mult = getConsoDay(day) / 100.;
		for (SchedulePart schp : scheduleDay) {
			count = 0;
			while (count < schp.getDuration()) {
				currentconso[i] += power * mult * schp.getConso() / 100.;
				i++;
				count++;
			}
		}
		return currentconso;
	}

	public int getConsoDay(int day) {
		for (SchedulePart sp : scheduleYear) {
			if (day < sp.getDurationCum()) {
				return sp.getConso();
			}
		}
		throw new IllegalArgumentException("Day must be inferior to 365");
	}

	@Override
	public String toString() {
		return "{" + " power='" + getPower() + "'" + ", schedule='" + getSchedule() + "'" + "}";
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof ElecEntity)) {
			return false;
		}
		ElecEntity elecEntity = (ElecEntity) o;
		return Objects.equals(scheduleDay, elecEntity.scheduleDay)
				&& Objects.equals(scheduleYear, elecEntity.scheduleYear) && power == elecEntity.power
				&& hSch == elecEntity.hSch && wSch == elecEntity.wSch && mSch == elecEntity.mSch;
	}

	@Override
	public int hashCode() {
		return Objects.hash(scheduleDay, scheduleYear, power, hSch, wSch, mSch);
	}

}
