package utilitary.time;

abstract public class TimeManagement {
	// TODO say it's constant or change
	private static final Day firstOfTheYear = Day.SATURDAY;

	public static int whichDay(int day) {
		int todaynum = (7 + day - firstOfTheYear.number) % 7;
		return todaynum;
	}

	public static int whichMonth(int day) {
		return Month.dayToMonth(day).getNumber();
	}

	public static void main(String[] args) {

	}
}
