package co.edu.ucentral.proybase.services;

import co.edu.ucentral.proybase.entity.TipoCita;

import java.util.List;

public interface ITipoCitaService {



    public List<TipoCita> obtenerTiposCita();

    public void agregarTipoCita(TipoCita tipoCita);

    public void eliminarTipoCita(TipoCita tipoCita);
}
