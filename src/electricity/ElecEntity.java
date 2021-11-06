package electricity;
abstract public class ElecEntity {
    private double power;
    private Schedule schedule;

    public ElecEntity(double power, Schedule schedule) {
        this.power = power;
        this.schedule = schedule;
    }

    
}
