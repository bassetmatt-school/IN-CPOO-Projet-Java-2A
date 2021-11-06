package electricity;
abstract public class PowerPlant extends ElecEntity{

    public PowerPlant(double power, Schedule schedule)
    {
        super(power,schedule);
    }

    /**
     * 
     * @param a
     * 
     * @return double[1440] prod of the day
     */
    public void dayProd(int a) {
        
    }

}
