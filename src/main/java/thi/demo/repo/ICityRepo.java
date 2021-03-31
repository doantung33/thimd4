package thi.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import thi.demo.model.City;

@Repository
public interface ICityRepo extends CrudRepository<City,Long> {
}
