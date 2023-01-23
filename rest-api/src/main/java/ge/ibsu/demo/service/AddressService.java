package ge.ibsu.demo.service;

import ge.ibsu.demo.dto.AddAddressDTO;
import ge.ibsu.demo.dto.AddCustomerDTO;
import ge.ibsu.demo.entity.Address;
import ge.ibsu.demo.entity.City;
import ge.ibsu.demo.entity.Customer;
import ge.ibsu.demo.repository.AddressRepository;
import ge.ibsu.demo.repository.CityRepository;
import ge.ibsu.demo.repository.CustomerRepository;
import ge.ibsu.demo.util.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CityRepository cityRepository;

    public List<Address> retrieveAllAddress() {
        return addressRepository.findAll();
    }

    @Transactional
    public Address addAddress(AddAddressDTO addAddressDTO) throws Exception {

        Address address = new Address();
        GeneralUtil.getCopyOf(addAddressDTO, address);
        address.setDistrict("defaultDistrict");
        address.setPhone("DefaultPhone");
        City city = new City();
        city.setCityName(addAddressDTO.getCityName());
        city.setCountryId(addAddressDTO.getCountryId());
        city = cityRepository.save(city);

        address.setCity(city);

        return addressRepository.save(address);
    }
}
