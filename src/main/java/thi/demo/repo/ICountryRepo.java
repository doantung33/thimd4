package thi.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import thi.demo.model.Country;
@Repository
public interface ICountryRepo extends CrudRepository<Country,Long> {
}
