package thi.demo.service.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thi.demo.model.City;
import thi.demo.repo.ICityRepo;

import java.util.List;

@Service
public class CityService implements ICityService{
    @Autowired
    private ICityRepo cityRepo;

    @Override
    public List<City> findAll() {
        return (List<City>) cityRepo.findAll();
    }

    @Override
    public City findById(Long id) {
        return cityRepo.findById(id).get();
    }

    @Override
    public City save(City city) {
        return cityRepo.save(city);
    }

    @Override
    public void remove(Long id) {
        cityRepo.deleteById(id);
    }
}
