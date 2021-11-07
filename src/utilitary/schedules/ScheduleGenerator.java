package utilitary.schedules;

import java.sql.Time;
import java.util.ArrayList;
import utilitary.time.TimeManagement;

public class ScheduleGenerator {
	private int[] weekSch;
	private int[] monthSch; 
	
	public ScheduleGenerator() {
		this.setWeekSch(new int[7]);
		this.setMonthSch(new int[12]);
	}

	public int[] getMonthSch() {
		return monthSch;
	}
	public int[] getWeekSch() {
		return weekSch;
	}


	public void setMonthSch(int[] monthSch) {
		this.monthSch = monthSch;
	}
	public void setMonthSch(int monthValue, int i) {
		this.monthSch[i] = monthValue;
	}

	public void setWeekSch(int[] weekSch) {
		this.weekSch = weekSch;
	}
	public void setWeekSch(int weekValue, int i) {
		this.weekSch[i] = weekValue;
	}

	public int[] toArray() {
		int[] sch = new int[365];
		int weekday = TimeManagement.whichDay(0);
		int month;
		for (int day = 0; day <365; day++) {
			month = TimeManagement.whichMonth(day);
			sch[day] = weekSch[weekday]*monthSch[month]/100;
		}
		return sch;
	}

	public ArrayList<SchedulePart> toYearSchedule(int[] schArray) {
		ArrayList<SchedulePart> ySch = new ArrayList<SchedulePart>();
		int duration = 1;
		int current = schArray[0];
		for (int day=1; day<365; day++) {
			if (schArray[day] == current) {
				duration++;
			} else {
				ySch.add(new SchedulePart(current, duration));
				current = schArray[day];
				duration = 1;
			}
		}
		return ySch;
	}
}
