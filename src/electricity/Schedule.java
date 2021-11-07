package electricity;

import java.util.ArrayList;

abstract public class Schedule {
	protected ArrayList<int[]> yearSchedule;
	protected ArrayList<int[]> daySchedule;

	public Schedule() {
		this.yearSchedule = new ArrayList<int[]>();
		this.daySchedule = new ArrayList<int[]>();
	}
	public Schedule(ArrayList<int[]> yearSchedule, ArrayList<int[]> daySchedule) {
		this.yearSchedule = yearSchedule;
		this.daySchedule = daySchedule;
	}

	public ArrayList<int[]> getYearSchedule() {
		return this.yearSchedule;
	}

	public ArrayList<int[]> getDaySchedule() {
		return this.daySchedule;
	}



}
