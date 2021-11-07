package city;

public class Environment {
    private Weather weather;

    public Environment() {
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Environment(Weather weather) {
        this.setWeather(weather);
    }
    
    //TODO all kind of events

}
