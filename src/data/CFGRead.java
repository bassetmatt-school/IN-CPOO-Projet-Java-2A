package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CFGRead {

	/** TODO complete
	 * readFile is big method to read
	 * @param file the file
	 * @return String
	 * @throws IOException
	 */
	private static ArrayList<String> readFile(String file) throws IOException{
		BufferedReader in;
		in = new BufferedReader(new FileReader(file));
		String str = in.readLine();
		ArrayList<String> relevantInfo = new ArrayList<String>();
		while (str != null) {
			if (str.equals("") || str.charAt(0) == '#') {
				str = in.readLine();
				continue;
			}
			relevantInfo.add(str);
			str = in.readLine();
		}
		in.close();
		return relevantInfo;
	}

	/**
	 * readEntitySettings is method for this cfg
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<DeviceProp> readEntitysettings() throws IOException{
		ArrayList<DeviceProp> deviceListSettings = new ArrayList<DeviceProp>();
		ArrayList<String> relevantInfo;
		relevantInfo = readFile("config/entitysettings.cfg");
		int step = 0;

		String name = "";
		double power=0;
		int d_sch_id=0, w_sch_id=0, m_sch_id=0;
		for (String str : relevantInfo) {
			str = str.split("= ")[1];
			switch (step) {
			case 0:
				name = str;
				step++;
				break;
			case 1 :
				power = Double.parseDouble(str);
				step++;
				break;
			case 2 :
				d_sch_id = Integer.parseInt(str);
				step++;
				break;
			case 3 :
				w_sch_id = Integer.parseInt(str);
				step++;
				break;
			case 4 :
				m_sch_id = Integer.parseInt(str);  
				step = 0;
				deviceListSettings.add(new DeviceProp(name, power, d_sch_id, w_sch_id, m_sch_id));
				break;
			default:
				break;
			}
		}
		return deviceListSettings;

	}

	private static ArrayList<int[]> extractDataMonthWeek(String file, int size) throws IOException {
		ArrayList<int[]> scheduleList = new ArrayList<int[]>();
		ArrayList<String> relevantInfo;
		relevantInfo = readFile(file);
		
		int step = 0;
		int[] sch = null;
		for (String str : relevantInfo) {
			if (step == 0) {
				step++;
				sch = new int[size];
			} else if (step <= size) {
				str = str.split("= ")[1];
				sch[step-1] = Integer.parseInt(str);
				step++;
			} else if (step == size+1) {
				step = 1;
				scheduleList.add(sch);
				sch = new int[size];
			}
		}
		scheduleList.add(sch);
		return scheduleList;
	}

	public static ArrayList<int[]> readScheduleMonth() throws IOException {
		return extractDataMonthWeek("config/schedules_month.cfg", 12);
	}

	public static ArrayList<int[]> readScheduleWeek() throws IOException {
		return extractDataMonthWeek("config/schedules_week.cfg", 7);
	}

	public static ArrayList<ArrayList<int[]>> readScheduleDay() throws IOException {
		ArrayList<ArrayList<int[]>> scheduleList = new ArrayList<ArrayList<int[]>>();
		ArrayList<String> relevantInfo;
		relevantInfo = readFile("config/schedules_day.cfg");
		
		ArrayList<int[]> sch = null;
		for (String str : relevantInfo) {
			if (str.charAt(0) == 'i') {
				if (sch != null) {
					scheduleList.add(sch);
				} 
				sch = new ArrayList<int[]>();
			} else {
				str = str.split("= ")[1];
				String[] params = str.split("-");
				sch.add(new int[]{Integer.parseInt(params[0]),
								  Integer.parseInt(params[1]),
								  Integer.parseInt(params[2])});
			}
		}
		scheduleList.add(sch);
		return scheduleList;
	}
	//TODO dégager
	public static void main(String[] args) throws IOException {
		ArrayList<DeviceProp> devlist = readEntitysettings();
		System.out.println(devlist);
		ArrayList<int[]> scheduleListMonth = readScheduleMonth();
		for (int[] arr : scheduleListMonth) {
			for (int i : arr) {
				System.out.print(i+"-");
			}
			System.out.println("");
		}
		ArrayList<ArrayList<int[]>> scheduleListDay = readScheduleDay();
		for (ArrayList<int[]> x: scheduleListDay) {
			for (int[] y : x) {
				for (int i : y) {
					System.out.print(i+"-");
				}
				System.out.println("");
			}
			System.out.println("");
		}
		
	}
}

