package utilitary.time;

public enum Day {
	MONDAY(0), TUESDAY(1), WEDNESDAY(2), THURSDAY(3), FRIDAY(4), SATURDAY(5), SUNDAY(6);

	public final int number;

	private Day(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public final static Day numToDay(int num) throws IllegalArgumentException {
		Day day = null;
		switch (num) {
		case 0:
			day = MONDAY; 
			break;
		case 1:
			day = TUESDAY;
			break;
		case 2:
			day = WEDNESDAY;
			break;
		case 3:
			day = THURSDAY;
			break;
		case 4:
			day = FRIDAY;
			break;
		case 5:
			day = SATURDAY;
			break;
		case 6:
			day = SUNDAY;
			break;
		default:
			throw new IllegalArgumentException("Day number must be between 0 and 6");
		}
		return day;
	}

}
