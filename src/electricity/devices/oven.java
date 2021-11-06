package electricity.devices;
import electricity.Device;
import electricity.Schedule;

public class oven extends Device{
    
    public oven(double power, Schedule schedule)
    {
        super(power,schedule);
    }
    
    public static void main(String[] args) {
        System.out.println("isok");
    }
}
