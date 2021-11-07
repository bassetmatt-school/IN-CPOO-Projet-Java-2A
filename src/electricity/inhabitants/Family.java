package electricity.inhabitants;

import electricity.Consumer;
import electricity.devices.Oven;
public class Family extends Consumer{
    public Family() {
        super();
        this.addDevice(new Oven());
    }

}
