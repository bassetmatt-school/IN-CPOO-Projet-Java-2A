package electricity;

import java.util.ArrayList;

public class ScheduleConso extends Schedule{
	public ScheduleConso() {
		super(new ArrayList<int[]>(), new ArrayList<int[]>());
	}
	
	public ScheduleConso(ArrayList<int[]> yearSchedule, ArrayList<int[]> daySchedule) {
		super(yearSchedule,daySchedule);
	}

	public void setYearSchedule(ArrayList<int[]> yearSchedule) {
		this.yearSchedule = yearSchedule;
	}

	public void setDaySchedule(ArrayList<int[]> daySchedule) {
		this.daySchedule = daySchedule;
	}
	
}
