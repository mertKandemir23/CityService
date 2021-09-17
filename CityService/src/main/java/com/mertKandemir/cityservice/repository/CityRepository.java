package com.mertKandemir.cityservice.repository;

import com.mertKandemir.cityservice.model.City;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CityRepository extends MongoRepository<City, String> {
    List<City> findByName(String name);
}
