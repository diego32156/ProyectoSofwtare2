package co.edu.ucentral.proybase.services;

import co.edu.ucentral.proybase.dao.IClienteDao;
import co.edu.ucentral.proybase.entity.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl  implements IClienteService{


    @Autowired
    private IClienteDao clienteDao;

    @Override
    public List<Clientes> findAll() {
        return (List<Clientes>) clienteDao.findAll();
    }

    @Override
    public Clientes findById(long id) {
        return clienteDao.findById(id).orElse(null);
    }

    public  Clientes save(Clientes cliente){
        return  clienteDao.save(cliente);
    }

    @Override
    public void delete(long id) {
        clienteDao.deleteById(id);
    }


}
