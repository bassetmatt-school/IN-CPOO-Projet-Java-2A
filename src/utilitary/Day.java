package utilitary;

public enum Day {
	MONDAY(0), TUESDAY(1), WEDNESDAY(2), THURSDAY(3), FRIDAY(4), SATURDAY(5), SUNDAY(6);

	public final int number;

	private Day(int number) {
		this.number = number;
	}

	public int getNumber() {
		return this.number;
	}

	public final static Day numToDay(int num) throws IllegalArgumentException {
		Day day = null;
		switch (num) {
		case 0:
			day = Day.MONDAY;
			break;
		case 1:
			day = Day.TUESDAY;
			break;
		case 2:
			day = Day.WEDNESDAY;
			break;
		case 3:
			day = Day.THURSDAY;
			break;
		case 4:
			day = Day.FRIDAY;
			break;
		case 5:
			day = Day.SATURDAY;
			break;
		case 6:
			day = Day.SUNDAY;
			break;
		default:
			throw new IllegalArgumentException("Day number must be between 0 and 6");
		}
		return day;
	}

}
