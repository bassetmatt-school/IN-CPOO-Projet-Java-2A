package electricity.plants;

import electricity.PowerPlant;
import utilitary.schedules.Schedule;

public class Nuclear extends PowerPlant{
    private static double pow = 3600; //W

    private static Schedule sch = new Schedule();
    

    public Nuclear() {
        super(pow);
        sch.stdSchedule();
        this.setSchedule(sch);;
    }
}
