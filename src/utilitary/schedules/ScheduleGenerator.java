package utilitary.schedules;

import java.util.ArrayList;

import utilitary.time.TimeManagement;

abstract public class ScheduleGenerator {
	//TODO controle visible
	//Array part
	private static int[] toArray(ArrayList<int[]> daySch) {
		int[] sch = new int[1440];
		int beg, end, conso;
		for (int[] zone : daySch) {
			beg = zone[0];
			end = zone[1];
			conso = zone[2];
			for (int i = beg*60; i < end*60;i++) {
				sch[i] = conso;
			}
		}
		return sch;

	}

	private static int[] toArray(int[] weekSch, int[] monthSch) {
		int[] sch = new int[365];
		int weekday = TimeManagement.whichDay(0);
		int month;
		for (int day = 0; day <365; day++) {
			month = TimeManagement.whichMonth(day);
			sch[day] = weekSch[weekday]*monthSch[month]/100;
			weekday++;
			weekday %= 7;
		}
		return sch;
	}

	//Schedule part
	private static ArrayList<SchedulePart> toSchedule(int[] schArray, int size) {
		ArrayList<SchedulePart> schedule = new ArrayList<SchedulePart>();
		int duration = 1;
		int current = schArray[0];
		for (int i=1; i<size; i++) {
			if (schArray[i] == current) {
				duration++;
			} else {
				schedule.add(new SchedulePart(current, duration));
				current = schArray[i];
				duration = 1;
			}
		}
		schedule.add(new SchedulePart(current, duration));
		return schedule;
	}

	private static ArrayList<SchedulePart> toScheduleYear(int[] schArray) {
		return toSchedule(schArray, 365);
	}

	private static ArrayList<SchedulePart> toScheduleDay(int[] schArray) {
		return toSchedule(schArray, 1440);
	}

	protected static Schedule generateSchedule(ArrayList<int[]> daySch, int[] weekSch, int[] monthSch) {
		Schedule schedule = new Schedule();
		ArrayList<SchedulePart> yearSchedule = toScheduleYear(toArray(weekSch, monthSch));
		ArrayList<SchedulePart> daySchedule = toScheduleDay(toArray(daySch));
		schedule.setDaySchedule(daySchedule);
		schedule.setYearSchedule(yearSchedule);
		return schedule;
	}

	//TODO dégager
	public static void main(String[] args) {
		int[] weektest = new int[]{75, 75, 50, 50, 25, 25, 0};
		int[] monthtest = new int[]{0, 0, 0, 25, 50, 75, 100, 100, 75, 25, 0, 0};
		
		int[] ytbl = ScheduleGenerator.toArray(weektest,monthtest);
		ArrayList<SchedulePart> ySch = ScheduleGenerator.toScheduleYear(ytbl);
		System.out.println(ySch);
		
		int[] zone1 = new int[]{0,7,0};
		int[] zone2 = new int[]{7,20,100};
		int[] zone3 = new int[]{20,24,25};
		ArrayList<int[]> daytest = new ArrayList<int[]>();
		daytest.add(zone1);
		daytest.add(zone2);
		daytest.add(zone3);

		int[] dtbl = ScheduleGenerator.toArray(daytest);
		ArrayList<SchedulePart> dsch = ScheduleGenerator.toScheduleDay(dtbl);
		System.out.println(dsch);

		Schedule sch = ScheduleGenerator.generateSchedule(daytest,weektest,monthtest);
		System.out.println(sch);
	}
}
