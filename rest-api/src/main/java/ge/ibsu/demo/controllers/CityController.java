package ge.ibsu.demo.controllers;

import ge.ibsu.demo.dto.AddCityDTO;
import ge.ibsu.demo.entity.City;
import ge.ibsu.demo.service.CityService;
import ge.ibsu.demo.util.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {"application/json"})
    public List<City> getAllCities(){
        return cityService.retrieveAllCities();
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json"})
    public City addCity(@RequestBody AddCityDTO rd) throws Exception{
        GeneralUtil.checkRequiredProperties(rd, Arrays.asList("cityName","countryId"));
        return cityService.addCity(rd);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public City editCity(@PathVariable Long id) throws Exception{
        return cityService.getCity(id);
    }
}
