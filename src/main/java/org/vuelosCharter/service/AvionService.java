package org.vuelosCharter.service;

import org.vuelosCharter.dao.IDAO;
import org.vuelosCharter.models.Avion;
import java.util.List;

public class AvionService {
    private IDAO<Avion> avionIDAO;

    public AvionService(IDAO<Avion> avionIDAO) {
        this.avionIDAO = avionIDAO;
    }

    public void setAvionIDAO(IDAO<Avion> avionIDAO) {
        this.avionIDAO = avionIDAO;
    }

    public Avion registrarAvion(Avion avion){
        return avionIDAO.registrarAvion(avion);
    }

    public Avion traerAvion(Integer id){
        return avionIDAO.traerAvion(id);
    }

    public void eliminarAvion(Integer id){ avionIDAO.darDeBajaAvion(id); }

    public List<Avion> traerAviones(){
        return avionIDAO.visualizarTodaLaFlota();
    }

}
