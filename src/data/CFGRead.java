package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CFGRead {

	/**
	 * A function that reads a .cfg file, so it removes the commentaries and empty
	 * spaces
	 * 
	 * @param file the file to read
	 * @return the relevant information contained in the file in an ArrayList of
	 *         Strings, one element per line
	 * @throws IOException if the file can't be found
	 */
	private static ArrayList<String> readFile(String file) throws IOException {
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
	 * A method to read the properties files adapted to their format
	 * 
	 * @param file the file to read
	 * @return A list of all the properties of the devices described in the file
	 * @throws IOException
	 */
	private static ArrayList<EntityProp> readEntitysettings(String file) throws IOException {
		ArrayList<EntityProp> deviceListSettings = new ArrayList<EntityProp>();
		ArrayList<String> relevantInfo;
		relevantInfo = readFile(file);
		int step = 0;

		String name = "";
		double power = 0;
		int d_sch_id = 0, w_sch_id = 0, m_sch_id = 0;
		for (String str : relevantInfo) {
			str = str.split("= ")[1];
			switch (step) {
				case 0:
					name = str;
					step++;
					break;
				case 1:
					power = Double.parseDouble(str);
					step++;
					break;
				case 2:
					d_sch_id = Integer.parseInt(str);
					step++;
					break;
				case 3:
					w_sch_id = Integer.parseInt(str);
					step++;
					break;
				case 4:
					m_sch_id = Integer.parseInt(str);
					step = 0;
					deviceListSettings.add(new EntityProp(name, power, d_sch_id, w_sch_id, m_sch_id));
					break;
				default:
					break;
			}
		}
		return deviceListSettings;
	}

	/**
	 * Specific method for the devices, just an execution of `readEntitysettings`
	 * 
	 * @return A list of the properties of the devices
	 * @throws IOException
	 */
	public static ArrayList<EntityProp> devicesProps() throws IOException {
		return readEntitysettings("config/properties_devices.cfg");
	}

	/**
	 * Specific method for the plants, just an execution of `readEntitysettings`
	 * 
	 * @return A list of the properties of the plants
	 * @throws IOException
	 */
	public static ArrayList<EntityProp> plantsProps() throws IOException {
		return readEntitysettings("config/properties_plants.cfg");
	}

	/**
	 * Extracts the data from the schedule files for the months and weeks the code
	 * is centralized in one method because the two files have the same format
	 * 
	 * @param file the file to read
	 * @param size the number of fields in the schedule
	 * @return An ArrayList with the data of the schedule
	 * @throws IOException
	 */
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
				sch[step - 1] = Integer.parseInt(str);
				step++;
			} else if (step == size + 1) {
				step = 1;
				scheduleList.add(sch);
				sch = new int[size];
			}
		}
		scheduleList.add(sch);
		return scheduleList;
	}

	/**
	 * Specific method for the months, just an execution of `extractDataMonthWeek`
	 * 
	 * @return An ArrayList with the data of the schedule
	 * @throws IOException
	 */
	public static ArrayList<int[]> readScheduleMonth() throws IOException {
		return extractDataMonthWeek("config/schedules_month.cfg", 12);
	}

	/**
	 * Specific method for the weeks, just an execution of `extractDataMonthWeek`
	 * 
	 * @return An ArrayList with the data of the schedule
	 * @throws IOException
	 */
	public static ArrayList<int[]> readScheduleWeek() throws IOException {
		return extractDataMonthWeek("config/schedules_week.cfg", 7);
	}

	/**
	 * Extracts the data from the schedule files for days
	 * 
	 * @return An ArrayList with the data of the schedule
	 * @throws IOException
	 */
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
				sch.add(new int[] { Integer.parseInt(params[0]), Integer.parseInt(params[1]),
						Integer.parseInt(params[2]) });
			}
		}
		scheduleList.add(sch);
		return scheduleList;
	}
}
