package utilitary;
public class TimeManagement {
    private Day today;
    private Day firstOfTheYear;
    public int timeToDay(int time) {
        return time/1440;
    }

    /**
     * Constructor of the class
     * @param firstOfTheYear
     */
    public TimeManagement(Day firstOfTheYear) {
        this.firstOfTheYear = firstOfTheYear;
    }

    public Day getToday() {
        return this.today;
    }

    public void setFirstOfTheYear(Day firstOfTheYear) {
        this.firstOfTheYear = firstOfTheYear;
    }

    public void whichDay(int time)
    {
        int todaynum = (timeToDay(time) - firstOfTheYear.number)%7;
        this.today = Day.numToDay(todaynum);
    }
    /* Maybe stupid
    public void whichMonth(int time) {
        return time/(1440*30);
    }
    */
    public static void main(String[] args) {
        
    }
}
