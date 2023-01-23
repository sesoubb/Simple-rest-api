package ge.ibsu.demo.controllers;

import ge.ibsu.demo.dto.AddAddressDTO;
import ge.ibsu.demo.dto.AddCityDTO;
import ge.ibsu.demo.entity.Address;
import ge.ibsu.demo.entity.City;
import ge.ibsu.demo.service.AddressService;
import ge.ibsu.demo.util.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;
    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {"application/json"})
    public List<Address> getAll() {
        return addressService.retrieveAllAddress();
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json"})
    public Address addAddress(@RequestBody AddAddressDTO rd) throws Exception{
        GeneralUtil.checkRequiredProperties(rd, Arrays.asList("address","cityName","countryId"));
        return addressService.addAddress(rd);
    }
}
