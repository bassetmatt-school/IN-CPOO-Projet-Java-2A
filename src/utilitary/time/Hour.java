package utilitary.time;

public class Hour {
    private int hours;
    private int minutes;

    public Hour(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public int getHours() {
        return this.hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public String toString() {
        return "(" +getHours() + ":" +
            getMinutes()+ ")";
    }


    public int toMinutes() {
        return hours*60 + minutes;
    }
}
