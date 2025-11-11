package uz.xakimov.project1.dto;

import uz.xakimov.project1.models.Sensor;

public class SensorDataDTO {

    private Sensor sensor;
    private double temperature;
    private boolean rain;

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public boolean isRain() {
        return rain;
    }

    public void setRain(boolean rain) {
        this.rain = rain;
    }
}
