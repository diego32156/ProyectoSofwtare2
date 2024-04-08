package co.edu.ucentral.proybase.services;

import co.edu.ucentral.proybase.entity.Clientes;

import java.util.List;

public interface IClienteService {

    public List<Clientes> findAll();
    public Clientes findById(long id);

    public Clientes save (Clientes cliente);

    public void  delete (long id);
}
