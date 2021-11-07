package utilitary.schedules;

import java.io.IOException;
import java.util.ArrayList;

import data.CFGRead;

public class ScheduleGeneratorDirect {
    private ArrayList<ArrayList<int[]>> daySchedList;
    private ArrayList<int[]> weekSchedList;
    private ArrayList<int[]> monthSchedList;

    public ScheduleGeneratorDirect() throws IOException {
        this.daySchedList = CFGRead.readScheduleDay();
        this.weekSchedList = CFGRead.readScheduleWeek();
        this.monthSchedList = CFGRead.readScheduleMonth();
    }

    public Schedule generateScheduleID(int id_d, int id_w, int id_m) {
        ArrayList<int[]> daySch = daySchedList.get(id_d);
        int[] weekSch = weekSchedList.get(id_w);
        int[] monthSch = monthSchedList.get(id_m);
        return ScheduleGenerator.generateSchedule(daySch, weekSch, monthSch);
    }
    
}
