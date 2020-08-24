package pl.bykowski.prework.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.bykowski.prework.entities.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

    Iterable<Vehicle> findAllByColor(String color);
}
