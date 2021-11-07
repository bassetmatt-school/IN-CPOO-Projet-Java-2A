package utilitary.schedules;

import java.util.ArrayList;

public class Schedule {
	private ArrayList<SchedulePart> yearSchedule;
	private ArrayList<SchedulePart> daySchedule;

	public Schedule() {
		this.yearSchedule = new ArrayList<SchedulePart>();
		this.daySchedule  = new ArrayList<SchedulePart>();
	}
	
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

	
	public void stdSchedule() {
        this.yearSchedule.add(new SchedulePart(100,365));
        this.daySchedule.add(new SchedulePart(100,1440));
    }

}
