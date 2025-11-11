package uz.xakimov.project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.xakimov.project1.models.SensorData;

@Repository
public interface SensorDataRepository extends JpaRepository<SensorData,Integer> {
}
