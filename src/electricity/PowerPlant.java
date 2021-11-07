package electricity;

import utilitary.schedules.Schedule;

public class PowerPlant extends ElecEntity {

	public PowerPlant(double power) {
		super(power);
	}

	public PowerPlant(double power, Schedule schedule) {
		super(power,schedule);
	}
}

