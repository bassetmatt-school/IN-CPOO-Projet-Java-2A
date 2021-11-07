package electricity;
public class Device extends ElecEntity{

	public Device() {
		super(0.,null);
	}

	public Device(double power, Schedule schedule) {
		super(power,schedule);
	}
}
