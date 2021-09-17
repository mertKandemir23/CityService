package com.mertKandemir.cityservice.controller;

import com.mertKandemir.cityservice.model.City;
import com.mertKandemir.cityservice.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Responsebody ve controller anatasyonlarının birleşmiş halidir.
@RestController
@RequestMapping("cities/")
@AllArgsConstructor
//Hangi urlde oluşacağı burada belirlenir.

public class CityController {
    private final CityService cityService;


    @GetMapping
    public ResponseEntity<?> getACity(@RequestParam(required = false) String name) {
        return new ResponseEntity<>(cityService.getCityByName(name), HttpStatus.OK);
    }


    @GetMapping("allcities/")
    public ResponseEntity<List<City>> getCities() {
        return new ResponseEntity<>(cityService.getCities(), HttpStatus.OK);
    }

    @GetMapping("city/{id}")
    public ResponseEntity<City> getCity(@PathVariable String id) {
        return new ResponseEntity<>(cityService.getCityById(id), HttpStatus.OK);
    }





       /*
                Stream sınıfının javadaki önemini burada görüyoruz. ->Java 8 ile gelmiştir.

            for(int i=0;< iller.size();i++){
            City city = city.get(i);
                if(il.getId().equals(id)){
                result = city
                }
                if(result == null)
                {
                   throw  new RuntimeException("Sehir bulunamadı")
               }

            }
            yazacağımıza

            iller.stream().filter(il->il.getId().equals(id))
            .findFirst().orElseThrow(()-> new Runtime Exception ( "City is not found"));


            restte iki strateji vardır ya void ya da object geri dönülür.Stringde geri verip id geri döneriz.

            Gelen nesnelerin City Class'ına ait olduğunu söylüyoruz.
            Ancak burada ProductRequest diye bir sınıf açıp o sınıfla erişmek ve sonra dto çevirip dto-entity dönüşümü yaparak
            Takılmak daha iyidir.Hem modelimizi dışarı açmamış oluruz.Hem güvenlik açısından daha iyidir.
            Burada CityRequest diye bir class açıp (dto)package içinde onun tipinde veri isteyebilirdik.Validasyon'u da orada ayarlayabilirdik.
*/

    @PostMapping("city")
    public ResponseEntity<City> createCity(@RequestBody City newCity) {


        return new ResponseEntity<>(cityService.createCity(newCity), HttpStatus.CREATED);
    }
    //Http.created dönüyoruz.Frontend de çalışan kişilere kolaylık oluyor.Her şeyde 200 ok  dönmek iyi bir şey değil.


    @PutMapping("city/{id}")
    public ResponseEntity<Void> updateCity(@PathVariable String id, @RequestBody City updatecity) {
        cityService.updateCity(id, updatecity);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("allcities")
    public ResponseEntity<Void> deleteCities() {
        cityService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("city/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable String id) {
        cityService.deleteCity(id);
        return new ResponseEntity<>("CITY DELETED", HttpStatus.OK);
    }




}
