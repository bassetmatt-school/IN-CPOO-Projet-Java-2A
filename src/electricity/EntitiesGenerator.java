package electricity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import data.CFGRead;

abstract public class EntitiesGenerator {
	private static TreeMap<String, int[]> devicesCFG;
	private static TreeMap<String, int[]> plantsCFG;
	private static TreeMap<String, String[]> consumersCFG;
	private static TreeMap<String, String[]> cityStrucureCFG;
	private static ArrayList<Consumer> cityPeople;
	private static ArrayList<PowerPlant> cityPlants;

	public static void getCFG() throws IOException {
		ArrayList<TreeMap<String, int[]>> entitiesCFG = CFGRead.readEntities();
		EntitiesGenerator.devicesCFG = entitiesCFG.get(0);
		EntitiesGenerator.plantsCFG = entitiesCFG.get(1);
		ArrayList<TreeMap<String, String[]>> cityCFG = CFGRead.readCity();
		EntitiesGenerator.consumersCFG = cityCFG.get(0);
		EntitiesGenerator.cityStrucureCFG = cityCFG.get(1);
	}

	public static ArrayList<Consumer> getCityPeople() {
		return cityPeople;
	}

	public static ArrayList<PowerPlant> getCityPlants() {
		return cityPlants;
	}

	public static TreeMap<String, Device> formatDeviceMap() throws IOException, IllegalArgumentException {
		if (devicesCFG == null) {
			getCFG();
		}
		TreeMap<String, Device> deviceMap = new TreeMap<String, Device>();
		int[] tempArray;
		for (String key : devicesCFG.keySet()) {
			tempArray = devicesCFG.get(key);
			deviceMap.put(key, new Device(tempArray));
		}
		return deviceMap;
	}

	public static TreeMap<String, PowerPlant> formatPlantMap() throws IOException, IllegalArgumentException {
		if (devicesCFG == null) {
			getCFG();
		}
		TreeMap<String, PowerPlant> plantMap = new TreeMap<String, PowerPlant>();
		int[] tempArray;
		for (String key : plantsCFG.keySet()) {
			tempArray = plantsCFG.get(key);
			plantMap.put(key, new PowerPlant(tempArray));
		}
		return plantMap;
	}

	public static TreeMap<String, Consumer> formatConsMap(TreeMap<String, Device> deviceMap)
			throws IOException, IllegalArgumentException {
		TreeMap<String, Consumer> consMap = new TreeMap<String, Consumer>();
		String[] tempList;
		// key = Familly
		ArrayList<Device> tempDeviceList;
		for (String key : consumersCFG.keySet()) {
			tempDeviceList = new ArrayList<Device>();
			tempList = consumersCFG.get(key);
			Device dev;
			for (String key2 : tempList) {
				dev = deviceMap.get(key2);
				tempDeviceList.add(dev);
			}
			consMap.put(key, new Consumer(tempDeviceList));
		}
		return consMap;
	}

	public static ArrayList<Consumer> formatCityPeople(TreeMap<String, Consumer> consMap)
			throws IOException, IllegalArgumentException {
		ArrayList<Consumer> cityPeople = new ArrayList<Consumer>();
		String[] consList = cityStrucureCFG.get("People");
		Consumer cons;
		for (String key : consList) {
			cons = consMap.get(key);
			cityPeople.add(cons);
		}
		return cityPeople;
	}

	public static ArrayList<PowerPlant> formatCityPlants(TreeMap<String, PowerPlant> plantMap)
			throws IOException, IllegalArgumentException {
		ArrayList<PowerPlant> cityPlants = new ArrayList<PowerPlant>();
		String[] consList = cityStrucureCFG.get("Plants");
		PowerPlant cons;
		for (String key : consList) {
			cons = plantMap.get(key);
			cityPlants.add(cons);
		}
		return cityPlants;
	}

	public static void generateCity() throws IOException {
		getCFG();
		TreeMap<String, Device> deviceMap = EntitiesGenerator.formatDeviceMap();
		TreeMap<String, PowerPlant> plantMap = EntitiesGenerator.formatPlantMap();
		TreeMap<String, Consumer> consumerMap = EntitiesGenerator.formatConsMap(deviceMap);
		ArrayList<Consumer> cityPeople = EntitiesGenerator.formatCityPeople(consumerMap);
		ArrayList<PowerPlant> cityPlants = EntitiesGenerator.formatCityPlants(plantMap);
		EntitiesGenerator.cityPeople = cityPeople;
		EntitiesGenerator.cityPlants = cityPlants;
	}

	public static void main(String[] args) throws IOException {
		generateCity();

		TreeMap<String, Device> dMap = formatDeviceMap();
		TreeMap<String, Consumer> consMap = formatConsMap(dMap);
		TreeMap<String, PowerPlant> plantMap = formatPlantMap();
		System.out.println(consMap);
		ArrayList<Consumer> ppl = formatCityPeople(consMap);
		System.out.println(ppl);
		ArrayList<PowerPlant> pow = formatCityPlants(plantMap);
		System.out.println(pow);

	}
}
