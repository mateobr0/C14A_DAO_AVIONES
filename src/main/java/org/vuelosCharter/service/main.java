package org.vuelosCharter.service;

import org.vuelosCharter.dao.IDAOH2Avion;
import org.vuelosCharter.models.Avion;

import java.time.LocalDate;
import java.lang.*;

public class main {
    public static void main(String[] args) {

        IDAOH2Avion.crearTablas();
        AvionService avionService=new AvionService(new IDAOH2Avion());

        Avion avion1 = new Avion("boing","747","e-400", LocalDate.now());
        Avion avion2 = new Avion("airbus","380","555-555",LocalDate.of(1992,8,13));

        avionService.registrarAvion(avion1);
        avionService.registrarAvion(avion2);

        System.out.println("Buscando avion");
        System.out.println(avionService.traerAvion(2));

        System.out.println("Buscando aviones");
        System.out.println(avionService.traerAviones());

        avionService.eliminarAvion(1);

        System.out.println("Buscando aviones denuevo");
        System.out.println(avionService.traerAviones());
    }
}
