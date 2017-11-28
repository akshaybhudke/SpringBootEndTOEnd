package com.boot.controller;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;
import javafx.beans.binding.When;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;

import javax.validation.constraints.AssertTrue;

import static org.junit.Assert.assertEquals;


public class ShipwreckControllerTest {

    @InjectMocks
    ShipwreckController shipwreckController;

    @Mock
    ShipwreckRepository shipwreckRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetMethod() {
        Shipwreck sw = new Shipwreck();
        sw.setId(1L);
        when(shipwreckRepository.findOne(1l)).thenReturn(sw);

        Shipwreck wreck = shipwreckController.get(1l);

        assertEquals(1L, wreck.getId().longValue());
    }

    @Test
    public void testCreateMethod() {

        Shipwreck sw = new Shipwreck();
        sw.setId(1L);
        sw.setName("AKhsa");
        sw.setLatitude(43.0);
        sw.setLongitude(33.54);

        Shipwreck newSw = new Shipwreck();
        newSw.setId(1L);
        newSw.setName("AKhsa");
        newSw.setLatitude(43.0);
        newSw.setLongitude(33.54);
        when(shipwreckRepository.saveAndFlush(sw)).thenReturn(newSw);

        Shipwreck result = shipwreckController.create(sw);

        assertEquals(sw.getId(), result.getId());


    }


}