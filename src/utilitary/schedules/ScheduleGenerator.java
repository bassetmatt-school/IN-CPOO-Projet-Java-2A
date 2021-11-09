package utilitary.schedules;

import java.io.IOException;
import java.util.ArrayList;

import data.CFGRead;
import utilitary.time.TimeManagement;

abstract public class ScheduleGenerator {

	private static int[] toArray(int[] weekSch, int[] monthSch) {
		int[] sch = new int[365];
		int weekday = TimeManagement.whichDay(0);
		int month;
		for (int day = 0; day < 365; day++) {
			month = TimeManagement.whichMonth(day);
			sch[day] = weekSch[weekday] * monthSch[month] / 100;
			weekday++;
			weekday %= 7;
		}
		return sch;
	}

	private static ArrayList<SchedulePart> toSchedule(int[] schArray, int type) {
		ArrayList<SchedulePart> schedule = new ArrayList<SchedulePart>();
		int size, multiplier;
		if (type == 0) {
			size = 365;
			multiplier = 1;
		} else if (type == 1) {
			size = 1440;
			multiplier = 60;
		} else {
			throw new IllegalArgumentException("type must be 0 or 1");
		}

		int duration = 1;
		int durationCum = 1;
		int current = schArray[0];
		// starts at 1 because index 0 is already threated
		for (int i = 1; i < size / multiplier; i++) {
			if (schArray[i] == current) {
				duration++;
			} else {
				schedule.add(new SchedulePart(current, duration * multiplier, durationCum * multiplier));
				current = schArray[i];
				duration = 1;
			}
			durationCum++;
		}
		schedule.add(new SchedulePart(current, duration * multiplier, durationCum * multiplier));
		return schedule;
	}

	public static Schedule generateSchedule(int id_d, int id_w, int id_m) throws IOException {
		ArrayList<ArrayList<int[]>> schedules = CFGRead.extractSchedules();
		int[] daySch = schedules.get(0).get(id_d);
		int[] weekSch = schedules.get(1).get(id_w);
		int[] monthSch = schedules.get(2).get(id_m);
		ArrayList<SchedulePart> yearSchedule = toSchedule(toArray(weekSch, monthSch), 0);
		ArrayList<SchedulePart> daySchedule = toSchedule(daySch, 1);
		return new Schedule(yearSchedule, daySchedule);
	}
}