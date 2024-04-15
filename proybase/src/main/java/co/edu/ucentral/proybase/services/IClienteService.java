package co.edu.ucentral.proybase.services;

import co.edu.ucentral.proybase.entity.Cliente;

import java.util.List;

public interface IClienteService {

    public List<Cliente> findAll();
    public Cliente findById(long id);

    public Cliente save (Cliente cliente);

    public void  delete (long id);
}
