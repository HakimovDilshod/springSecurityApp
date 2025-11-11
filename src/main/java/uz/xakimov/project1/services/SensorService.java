package uz.xakimov.project1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.xakimov.project1.dto.SensorDTO;
import uz.xakimov.project1.models.Sensor;
import uz.xakimov.project1.models.SensorData;
import uz.xakimov.project1.repositories.SensorRepository;
import uz.xakimov.project1.util.SensorFoundException;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SensorService {
    private SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }

    public Sensor getSensorById(int id) {
        return sensorRepository.findById(id).get();
    }

    @Transactional
    public void saveSensor(SensorDTO sensorDTO) {
        // Проверяем, существует ли сенсор с таким именем
        if (sensorRepository.findByName(sensorDTO.getName()).isPresent()) {
            throw new SensorFoundException("Sensor with name '" + sensorDTO.getName() + "' already exists");
        }

        sensorRepository.save(convertToSensor(sensorDTO));
    }

    public Sensor convertToSensor(SensorDTO sensorDTO) {
        Sensor sensor = new Sensor();
        sensor.setName(sensorDTO.getName());
        return sensor;
    }
}
