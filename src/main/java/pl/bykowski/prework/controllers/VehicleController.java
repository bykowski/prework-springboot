package pl.bykowski.prework.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.bykowski.prework.entities.Vehicle;
import pl.bykowski.prework.services.IdNotFoundException;
import pl.bykowski.prework.services.VehicleService;

@Controller
@ResponseBody
@RequestMapping("/api/cars")
public class VehicleController {

  private VehicleService vehicleService;

  @Autowired
  public VehicleController(VehicleService vehicleService) {
    this.vehicleService = vehicleService;
  }

  @GetMapping
  public List<Vehicle> getVehicles() {
    return vehicleService.findAllVehicles();
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
    Optional<Vehicle> vehicleById = vehicleService.findVehicleById(id);
    return vehicleById.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
  }

  @PutMapping
  public ResponseEntity<Void> updateCar(@Validated @RequestBody Vehicle vehicle) {
    vehicleService.updateVehicle(vehicle);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
