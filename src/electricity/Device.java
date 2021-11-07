package electricity;

import utilitary.schedules.Schedule;

public class Device extends ElecEntity{

	public Device() {
		super(0.);
	}

	public Device(double power) {
		super(power);
	}

	public Device(double power, Schedule schedule) {
		super(power,schedule);
	}


}
