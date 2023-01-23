package ge.ibsu.demo.repository;

import ge.ibsu.demo.entity.City;
import ge.ibsu.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
