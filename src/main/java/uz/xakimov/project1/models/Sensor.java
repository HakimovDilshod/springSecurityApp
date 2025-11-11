package uz.xakimov.project1.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Sensor {

    public Sensor() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @OneToMany(mappedBy = "sensor")
    private List<SensorData> sensorDataList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
