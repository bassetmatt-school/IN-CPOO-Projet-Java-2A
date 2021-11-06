package electricity;
abstract public class Device extends ElecEntity{

    public Device(double power, Schedule schedule)
    {
        super(power,schedule);
    }
    
}
