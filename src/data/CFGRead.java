package data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

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
	private static ArrayList<String> readFile(String file) throws IOException{
		BufferedReader in;
		ArrayList<String> relevantInfo = new ArrayList<String>();
		try {
			in = new BufferedReader(new FileReader(file));
			String str = in.readLine();
			
			while (str != null) {
				//line isn't empty or a comment
				if (!(str.equals("") || str.charAt(0) == '#')) {
					relevantInfo.add(str);
				}
				str = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException fnf) {
			throw new FileNotFoundException("File not found");
		} catch (IOException e) {
			throw new IOException("Problem while reading file + \""+file+"\", please check file");
		}
		return relevantInfo;
	}

	private static int[] strToArray(String str) {
		String[] stringArr = str.split(" ");
		int[] intArr = Arrays.stream(stringArr).mapToInt(Integer::parseInt).toArray();
		return intArr;
	}
	public static ArrayList<ArrayList<int[]>> extractSchedules() throws IOException {
		ArrayList<ArrayList<int[]>> allSchedulesArray = new ArrayList<ArrayList<int[]>>();
		ArrayList<String> fileInfo = readFile("config/schedules.cfg");
		ArrayList<int[]> tempArray = new ArrayList<int[]>();
		for (String str : fileInfo) {
			switch (str) {
				case "@day" :
					break;
				case "@week" :
					allSchedulesArray.add(tempArray);
					tempArray = new ArrayList<int[]>();
					break;
				case "@month" :
					allSchedulesArray.add(tempArray);
					tempArray = new ArrayList<int[]>();
					break;
				default:
					tempArray.add(strToArray(str));
					break;
			}
		}
		allSchedulesArray.add(tempArray);
		return allSchedulesArray;
	}


	
	public static ArrayList<TreeMap<String, int[]>> readEntities() throws IOException {
		ArrayList<TreeMap<String, int[]>> allEntities = new ArrayList<TreeMap<String, int[]>>();;
		ArrayList<String> fileInfo = readFile("config/elecentities.cfg");
		
		TreeMap<String, int[]> deviceMap = new TreeMap<String, int[]>();
		TreeMap<String, int[]> plantMap = new TreeMap<String, int[]>();;
		
		int indic = 0;
		String[] tempStringArray;
		int[] tempIntArray;

		for (String str : fileInfo) {
			switch (str) {
				case "@devices" :
					indic = 0;
					break;
				case "@plants" :
					indic = 1;
					break;
				default:
					tempStringArray = str.split(" : ");
					tempIntArray = strToArray(tempStringArray[1]);
					if (indic == 0) {
						deviceMap.put(tempStringArray[0], tempIntArray);
					} else {
						plantMap.put(tempStringArray[0], tempIntArray);
					}
					break;
			}
		}
		allEntities.add(deviceMap);
		allEntities.add(plantMap);
		return allEntities;
	}

	// Familly : Oven 2 : Fridge 1 => Familly : Oven Oven Fridge 
	public static ArrayList<String> formatRepeat(ArrayList<String> fileInfo) {
		ArrayList<String> formattedText = new ArrayList<String>();

		String[] linesplit;
		String[] subsplit;
		String tempStr;
		for (String str : fileInfo) {
			if (str.charAt(0) == '@') {
				formattedText.add(str);
				continue;
			}
			tempStr = "";
			linesplit = str.split(" : ");
			tempStr += linesplit[0] + " :";
			for (int i = 1; i< linesplit.length;i++) {
				subsplit = linesplit[i].split(" ");
				tempStr += (" " + subsplit[0]).repeat(Integer.parseInt(subsplit[1]));
			}
			formattedText.add(tempStr);
		}
		return formattedText;
	}

	public static ArrayList<TreeMap<String, String[]>> readCity() throws IOException {
		ArrayList<TreeMap<String, String[]>> city = new ArrayList<TreeMap<String, String[]>>();;
		ArrayList<String> formatFileInfo = formatRepeat(readFile("config/city.cfg"));

		TreeMap<String, String[]> consumers = new TreeMap<String, String[]>();
		TreeMap<String, String[]> cityPeople = new TreeMap<String, String[]>();;
		
		int indic = 0;
		String[] linesplit;
		String[] subsplit;

		for (String str : formatFileInfo) {
			switch (str) {
				case "@consumers" :
					indic = 0;
					break;
				case "@city " :
					indic = 1;
					break;
				default:
					linesplit = str.split(" : ");
					subsplit = linesplit[1].split(" ");
					if (indic == 0) {
						consumers.put(linesplit[0], subsplit);
					} else {
						cityPeople.put(linesplit[0], subsplit);
					}
					break;
			}
		}
		city.add(consumers);
		city.add(cityPeople);
		return city;
	}
}
