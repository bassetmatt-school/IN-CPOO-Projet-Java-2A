package electricity;

import java.util.ArrayList;

public class Consumer {
	private ArrayList<Device> deviceList;

	public Consumer() {
		this.deviceList = new ArrayList<Device>();
	}

	public Consumer(ArrayList<Device> deviceList) {
		this.deviceList = deviceList;
	}

	public ArrayList<Device> getDeviceList() {
		return deviceList;
	}

	public ArrayList<Device> setDeviceList(ArrayList<Device> deviceList) {
		return this.deviceList = deviceList;
	}

	@Override
	public String toString() {
		return "{" + " deviceList='" + getDeviceList() + "'" + "}";
	}

}
