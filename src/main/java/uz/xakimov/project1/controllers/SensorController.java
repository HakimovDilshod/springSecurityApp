package uz.xakimov.project1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.xakimov.project1.dto.SensorDTO;
import uz.xakimov.project1.models.Sensor;
import uz.xakimov.project1.services.SensorService;
import uz.xakimov.project1.util.SensorErorResponse;
import uz.xakimov.project1.util.SensorFoundException;

import java.util.List;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    private SensorService sensorService;

    @Autowired
    public void setSensorService(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping()
     public List<Sensor> getSensors() {
        return sensorService.getAllSensors();
    }

    @PostMapping
    public ResponseEntity<HttpStatus> saveSensor(@RequestBody SensorDTO sensorDTO) {
        sensorService.saveSensor(sensorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ExceptionHandler
    public ResponseEntity<SensorErorResponse> handleException(SensorFoundException e) {
        SensorErorResponse sensorErorResponse = new SensorErorResponse(
                "Sensor with this name already exists",
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(sensorErorResponse, HttpStatus.BAD_REQUEST);
    }
}
