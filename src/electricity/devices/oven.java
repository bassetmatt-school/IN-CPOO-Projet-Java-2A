package electricity.devices;
import java.util.ArrayList;

import electricity.Device;
import electricity.ScheduleConso;

public class Oven extends Device{
    private static double power = 2000; //W
    private static ArrayList<int[]> dSch = new ArrayList<int[]>();
    private static ArrayList<int[]> ySch = new ArrayList<int[]>();
    
    private static ScheduleConso schedule = defineSchedules();
    
    public static ScheduleConso defineSchedules() {
        dSch.set(0,new int[]{100,1440});
        ySch.set(0,new int[]{100,365});
        return new ScheduleConso(ySch,dSch);
    }

    public Oven() {
        super(power, schedule);
    }

}
