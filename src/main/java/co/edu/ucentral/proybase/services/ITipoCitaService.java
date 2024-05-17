package co.edu.ucentral.proybase.services;

import co.edu.ucentral.proybase.entity.Cliente;
import co.edu.ucentral.proybase.entity.Sucursal;
import co.edu.ucentral.proybase.entity.TipoCita;

import java.util.List;

public interface ITipoCitaService {

    public List <TipoCita> findAll();

    public TipoCita findById(Long id);

    public TipoCita save (TipoCita tipoCita);

    public void delete (long id);
}
