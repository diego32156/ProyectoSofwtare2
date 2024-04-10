package co.edu.ucentral.proybase.dao;

import co.edu.ucentral.proybase.entity.Clientes;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDao extends CrudRepository <Clientes, Long> {
}
