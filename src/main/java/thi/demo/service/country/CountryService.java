package thi.demo.service.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thi.demo.model.Country;
import thi.demo.repo.ICountryRepo;

import java.util.List;

@Service
public class CountryService implements ICountryService{
    @Autowired
    private ICountryRepo countryRepo;


    @Override
    public List<Country> findAll() {
        return (List<Country>) countryRepo.findAll();
    }

    @Override
    public Country findById(Long id) {
        return countryRepo.findById(id).get();
    }

    @Override
    public Country save(Country country) {
        return countryRepo.save(country);
    }

    @Override
    public void remove(Long id) {
        countryRepo.deleteById(id);
    }
}
