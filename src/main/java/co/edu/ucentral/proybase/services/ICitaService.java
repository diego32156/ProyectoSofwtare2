package co.edu.ucentral.proybase.services;

import co.edu.ucentral.proybase.entity.Cita;


import java.util.Date;
import java.util.List;

public interface ICitaService {

    public List <Cita> findAll();

    public Cita findById(Long id);

    public Cita save (Cita cita);

    public void delete (Long id);


}
