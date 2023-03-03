package org.vuelosCharter.dao;

import org.vuelosCharter.models.Avion;

import java.util.List;

public interface IDAO<T>{
    T registrarAvion(T t);
    T traerAvion(Integer id);
    void darDeBajaAvion(Integer id);
    List<T> visualizarTodaLaFlota();


}
