package electricity;

abstract public class ElecEntity {
	private double power = 0;
	private Schedule schedule = null;

	public ElecEntity(double power, Schedule schedule) {
		this.power = power;
		this.schedule = schedule;
	}

}
