package utilitary.schedules;

import java.util.ArrayList;

public class Schedule {
	/**
	 * A class to represent the fluctuations of production or consumption over the
	 * year
	 */
	/** The schedule day by day, considered relevant to be treated differently */
	private ArrayList<SchedulePart> yearSchedule;
	/**
	 * The schedule minute by minute, considered independant of the day (huge
	 * approx)
	 */
	private ArrayList<SchedulePart> daySchedule;

	/**
	 * Empty constructor initializing the fields with empty lists
	 */
	public Schedule() {
		this.yearSchedule = new ArrayList<SchedulePart>();
		this.daySchedule = new ArrayList<SchedulePart>();
	}

	/**
	 * Constructor with fields
	 */
	public Schedule(ArrayList<SchedulePart> yearSchedule, ArrayList<SchedulePart> daySchedule) {
		this.yearSchedule = yearSchedule;
		this.daySchedule = daySchedule;
	}

	public ArrayList<SchedulePart> getYearSchedule() {
		return this.yearSchedule;
	}

	public ArrayList<SchedulePart> getDaySchedule() {
		return this.daySchedule;
	}

	public void setYearSchedule(ArrayList<SchedulePart> yearSchedule) {
		this.yearSchedule = yearSchedule;
	}

	public void setDaySchedule(ArrayList<SchedulePart> daySchedule) {
		this.daySchedule = daySchedule;
	}

	@Override
	public String toString() {
		return "{" + " yearSchedule='" + getYearSchedule() + "'" + ",\n daySchedule='" + getDaySchedule() + "'" + "}";
	}
}
