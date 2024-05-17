package co.edu.ucentral.proybase.services;

import co.edu.ucentral.proybase.dao.ITipoCitaDao;
import co.edu.ucentral.proybase.entity.TipoCita;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoCitaServiceImpl implements ITipoCitaService {

    private ITipoCitaDao tipoCitaDao;


    @Override
    public List<TipoCita> findAll() {
        return (List<TipoCita>) tipoCitaDao.findAll();
    }

    @Override
    public TipoCita findById(Long id) {
        return  tipoCitaDao.findById(id).orElse(null);
    }


    @Override
    public TipoCita save(TipoCita tipoCita) {
        return tipoCitaDao.save(tipoCita);
    }

    @Override
    public void delete(long id) {
        tipoCitaDao.deleteById(id);
    }
}
