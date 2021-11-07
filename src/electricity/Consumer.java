package electricity;

import java.util.ArrayList;

public class Consumer {
	private ArrayList<Device> devicelist;

	public Consumer() {
		this.devicelist = new ArrayList<Device>();
	}

	public Consumer(ArrayList<Device> devicelist) {
		this.devicelist = devicelist;
	}

	public ArrayList<Device> getDevicelist() {
		return devicelist;
	}

	public ArrayList<Device> setDevicelist(ArrayList<Device> devicelist) {
		return this.devicelist = devicelist;
	}

	public void addDevice(Device dev) {
		this.devicelist.add(dev);
	}
}
