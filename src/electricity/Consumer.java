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
		return this.devicelist;
	}

	public void addDevice(Device dev) {
		this.devicelist.add(dev);
	}
}
