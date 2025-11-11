package uz.xakimov.project1.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.xakimov.project1.dto.SensorDTO;
import uz.xakimov.project1.dto.SensorDataDTO;
import uz.xakimov.project1.models.Sensor;
import uz.xakimov.project1.models.SensorData;
import uz.xakimov.project1.repositories.SensorDataRepository;
import uz.xakimov.project1.repositories.SensorRepository;

@Service
@Transactional(readOnly = true)
public class SensorDataService {
    private SensorDataRepository sensorDataRepository;

    @Autowired
    public SensorDataService(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }



    private Sensor convertToSensorData(SensorDataDTO sensorDataDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(sensorDataDTO, Sensor.class);

    }
}
