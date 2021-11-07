package electricity.devices;

import electricity.Device;
import utilitary.schedules.Schedule;

public class Oven extends Device{
    private static double pow = 1500; //W

    private static Schedule sch = new Schedule();
    
    public Oven() {
        super(pow);
        sch.stdSchedule();
        this.setSchedule(sch);;
    }
}