package pl.bykowski.prework.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Vehicle {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Min(1)
  private Long id;
  @NotBlank(message = "Brand cannot be empty!")
  private String brand;
  @NotBlank(message = "Model cannot be empty!")
  private String model;
  @NotBlank(message = "Color cannot be empty!")
  private String color;

  public Vehicle() {
  }

  public Vehicle(String brand, String model, String color) {
    this.brand = brand;
    this.model = model;
    this.color = color;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
}
