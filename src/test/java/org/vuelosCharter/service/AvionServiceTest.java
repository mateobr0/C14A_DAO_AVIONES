package org.vuelosCharter.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.vuelosCharter.dao.IDAOH2Avion;
import org.vuelosCharter.models.Avion;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AvionServiceTest {

    @Test
    void registrarAvionYTraerAvion() {
        IDAOH2Avion.crearTablas();
        AvionService avionService=new AvionService(new IDAOH2Avion());

        Avion avion1 = new Avion("boing","747","e-400", LocalDate.now());
        avionService.registrarAvion(avion1);
        Assertions.assertNotNull(avionService.traerAvion(1));
    }

    @Test
    void eliminarAvion() {
        IDAOH2Avion.crearTablas();
        AvionService avionService=new AvionService(new IDAOH2Avion());

        Avion avion1 = new Avion("boing","747","e-400", LocalDate.now());
        avionService.registrarAvion(avion1);
        Assertions.assertNotNull(avionService.traerAvion(1));
        avionService.eliminarAvion(1);
        Assertions.assertNull(avionService.traerAvion(1));
    }

    @Test
    void traerAviones() {
        IDAOH2Avion.crearTablas();
        AvionService avionService=new AvionService(new IDAOH2Avion());

        Avion avion1 = new Avion("boing","747","e-400", LocalDate.now());
        avionService.registrarAvion(avion1);
        assertEquals(1,avionService.traerAviones().size());
    }
}