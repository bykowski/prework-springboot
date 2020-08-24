package pl.bykowski.prework;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface CarReposiotroy extends CrudRepository<Car, Long> {

  @RestResource(path = "color")
  List<Car> findAllByColor(String color);

//  @Override
//  @RestResource(exported = false)
//  Car save(Car car);

}
