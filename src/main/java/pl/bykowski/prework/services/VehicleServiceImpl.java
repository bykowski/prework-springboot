package pl.bykowski.prework.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bykowski.prework.entities.Vehicle;
import pl.bykowski.prework.repositories.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

  private VehicleRepository vehicleRepository;

  @Autowired
  public VehicleServiceImpl(VehicleRepository vehicleRepository) {
    this.vehicleRepository = vehicleRepository;
  }

  @Override
  public List<Vehicle> findAllVehicles() {
    Iterable<Vehicle> vehicles = vehicleRepository.findAll();
    return StreamSupport.stream(vehicles.spliterator(), true)
        .collect(Collectors.toList());
  }

  @Override
  public Optional<Vehicle> findVehicleById(Long id) {
    return vehicleRepository.findById(id);
  }

  @Override
  public List<Vehicle> findAllVehiclesByColor(String color) {
    Iterable<Vehicle> vehicles = vehicleRepository.findAllByColor(color);
    return StreamSupport.stream(vehicles.spliterator(), true)
        .collect(Collectors.toList());
  }

  @Override
  public Vehicle saveVehicle(Vehicle vehicle) {
    return vehicleRepository.save(vehicle);
  }

  @Override
  public void updateVehicle(Vehicle vehicle) {
    if (vehicleRepository.existsById(vehicle.getId())) {
      vehicleRepository.save(vehicle);
    }
  }

  @Override
  public List<Vehicle> saveVehicleList(List<Vehicle> vehicleList) {
    Iterable<Vehicle> vehicleIterator = vehicleRepository.saveAll(vehicleList);
    return StreamSupport.stream(vehicleIterator.spliterator(), true).collect(Collectors.toList());
  }

}
