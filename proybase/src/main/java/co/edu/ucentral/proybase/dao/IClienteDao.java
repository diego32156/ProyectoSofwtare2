package co.edu.ucentral.proybase.dao;

import co.edu.ucentral.proybase.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDao extends CrudRepository <Cliente, Long> {
}
