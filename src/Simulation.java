import java.util.ArrayList;

import city.Environment;
import electricity.Consumer;
import electricity.Device;
import electricity.PowerPlant;

public class Simulation {
    private ArrayList<Consumer> consumerlist;
    private ArrayList<PowerPlant> plantlist;
    private Environment env;

    private ArrayList<Device> deviceList;

    public Simulation() {
        this.consumerlist = new ArrayList<Consumer>();
        this.plantlist = new ArrayList<PowerPlant>();
        this.env = new Environment();
    }

    public Simulation(ArrayList<Consumer> consumerlist, ArrayList<PowerPlant> plantlist, Environment env) {
        this.consumerlist = consumerlist;
        this.plantlist = plantlist;
        this.env = env;
    }

    public void addConsumer(Consumer cons) {
        this.consumerlist.add(cons);
    }

    public void addPlant(PowerPlant plant) {
        this.plantlist.add(plant);
    }



}
