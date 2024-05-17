package co.edu.ucentral.proybase.services;

import co.edu.ucentral.proybase.dao.ICitaDao;
import co.edu.ucentral.proybase.entity.Cita;
import co.edu.ucentral.proybase.entity.Cliente;
import co.edu.ucentral.proybase.entity.Sucursal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CitaServiceImpl implements ICitaService {

    @Autowired
    private ICitaDao citaDao;


    @Override
    public List<Cita> findAll() {
        return (List<Cita>) citaDao.findAll();
    }

    @Override
    public Cita findById(Long id) {
        return citaDao.findById(id).orElse(null);
    }

    @Override
    public Cita save(Cita cita) {

        return citaDao.save(cita);
    }

    @Override
    public void delete(Long id) {
        citaDao.deleteById(id);

    }
}
