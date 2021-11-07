package electricity;
public class PowerPlant extends ElecEntity {
	public PowerPlant() {
		super(0.,null);
	}

	public PowerPlant(double power, Schedule schedule) {
		super(power,schedule);
	}
}

