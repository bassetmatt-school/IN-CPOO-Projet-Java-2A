package utilitary.schedules;

/**
 * Easier to handle than a int[] array
 */
public class SchedulePart {
	private int conso;
	private int duration;
    private int durationCum;


    public SchedulePart(int conso, int duration) {
        this.conso = conso;
        this.duration = duration;
        this.durationCum = duration;
    }
    
    public SchedulePart(int conso, int duration, int durationCum) {
        this.conso = conso;
        this.duration = duration;
        this.durationCum = durationCum;
    }

    public int getConso() {
        return this.conso;
    }

    public void setConso(int conso) {
        this.conso = conso;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDurationCum() {
        return this.durationCum;
    }

    public void setDurationCum(int durationCum) {
        this.durationCum = durationCum;
    }


    @Override
    public String toString() {
        return "{" + getConso() +
            "," + getDuration()+ "}";
    }
    

}

