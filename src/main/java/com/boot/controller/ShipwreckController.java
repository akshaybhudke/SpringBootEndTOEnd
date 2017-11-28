package com.boot.controller;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class ShipwreckController {

    @Autowired
    ShipwreckRepository shipwreckRepository ;

    @RequestMapping(value = "shipwrecks" , method = RequestMethod.GET)
    List<Shipwreck> list(){

        return shipwreckRepository.findAll();
    }


    @RequestMapping(value = "shipwrecks" , method = RequestMethod.POST)
    Shipwreck create(@RequestBody Shipwreck shipwreak){

        return shipwreckRepository.saveAndFlush(shipwreak);
    }

    @RequestMapping(value = "shipwrecks/{id}" , method = RequestMethod.GET)
    Shipwreck get(@PathVariable  Long id){

        return shipwreckRepository.findOne(id);
    }

    @RequestMapping(value = "shipwrecks/{id}" , method = RequestMethod.PUT)
    Shipwreck update(@PathVariable  Long id,@RequestBody Shipwreck shipwreak){
        Shipwreck existingShipwreck = shipwreckRepository.findOne(id);
        BeanUtils.copyProperties(shipwreak,existingShipwreck);
        return shipwreckRepository.saveAndFlush(existingShipwreck);
    }

    @RequestMapping(value = "shipwrecks/{id}" , method = RequestMethod.DELETE)
    Shipwreck delete(@PathVariable  Long id){
        Shipwreck existingShipwreck = shipwreckRepository.findOne(id);
        shipwreckRepository.delete(existingShipwreck);
        return existingShipwreck;
    }





}
