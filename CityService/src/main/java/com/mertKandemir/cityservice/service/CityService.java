package com.mertKandemir.cityservice.service;

import com.mertKandemir.cityservice.exception.CityNotFoundException;
import com.mertKandemir.cityservice.model.City;
import com.mertKandemir.cityservice.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    public List<City> getCities() {

        return cityRepository.findAll();
    }


    public City createCity(City newCity) {

        newCity.setCreatedTime(new Date());
        cityRepository.save(newCity);

        return newCity;
    }

    public void deleteCity(String id) {
        cityRepository.deleteById(id);
    }

    public void deleteAll() {
        cityRepository.deleteAll();
    }

    public City getCityById(String id) {
        return cityRepository.findById(id).orElseThrow(()
                -> new CityNotFoundException("Girdiğiniz ID'ye ait şehir bulunamadı."));
    }

    public void updateCity(String id, City updatecity) {
        City oldCity = getCityById(id);
        oldCity.setName(updatecity.getName());
        cityRepository.save(oldCity);


    }


    public List<City> getCityByName(String name) {
        if(name == null){
            return cityRepository.findAll();
        }
        else{
            return cityRepository.findByName(name);
        }

    }
}
