package co.edu.ucentral.proybase.services;

import co.edu.ucentral.proybase.dao.IClienteDao;
import co.edu.ucentral.proybase.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl  implements IClienteService{


    @Autowired
    private IClienteDao clienteDao;

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }


    public Cliente save(Cliente cliente){
        return  clienteDao.save(cliente);
    }

    @Override
    public void delete(Long id) {
        clienteDao.deleteById(id);
    }



}
