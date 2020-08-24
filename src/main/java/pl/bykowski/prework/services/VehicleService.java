package pl.bykowski.prework.services;

import java.util.List;
import java.util.Optional;
import pl.bykowski.prework.entities.Vehicle;

public interface VehicleService {

  List<Vehicle> findAllVehicles();

  Optional<Vehicle> findVehicleById(Long id);

  List<Vehicle> findAllVehiclesByColor(String color);

  Vehicle saveVehicle(Vehicle vehicle);

  void updateVehicle(Vehicle vehicle);

  List<Vehicle>  saveVehicleList(List<Vehicle> vehicleList);

}
