package ge.ibsu.demo.service;

import ge.ibsu.demo.dto.AddCityDTO;
import ge.ibsu.demo.entity.Address;
import ge.ibsu.demo.entity.City;
import ge.ibsu.demo.entity.Customer;
import ge.ibsu.demo.repository.CityRepository;
import ge.ibsu.demo.util.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> retrieveAllCities(){
        return cityRepository.findAll();
    }

    @Transactional
    public City addCity(AddCityDTO addCityDTO) throws Exception{
        City city = new City();
        GeneralUtil.getCopyOf(addCityDTO,city);

        return cityRepository.save(city);
    }
    @Transactional
    public City getCity(Long id){
        return cityRepository.findById(id).orElse(null);
    }
}
