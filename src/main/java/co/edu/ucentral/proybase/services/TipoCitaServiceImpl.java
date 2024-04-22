package co.edu.ucentral.proybase.services;

import co.edu.ucentral.proybase.dao.ITipoCitaDao;
import co.edu.ucentral.proybase.entity.TipoCita;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoCitaServiceImpl implements ITipoCitaService {

    private ITipoCitaDao tipoCitaDao;

    private List<TipoCita> tiposCita;

    public TipoCitaServiceImpl(ITipoCitaDao tipoCitaDao){
        this.tipoCitaDao = tipoCitaDao;
        tiposCita = new ArrayList<>();
    }
    @Override
    public List<TipoCita> obtenerTiposCita() {
        return tiposCita;
    }

    @Override
    public void agregarTipoCita(TipoCita tipoCita) {
        tipoCitaDao.save(tipoCita);
    }

    @Override
    public void eliminarTipoCita(TipoCita tipoCita) {
        tipoCitaDao.delete(tipoCita);
    }
}
