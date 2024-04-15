package co.edu.ucentral.proybase.dao;

import co.edu.ucentral.proybase.entity.Sucursal;
import org.springframework.data.repository.CrudRepository;

public interface ISucursalDao extends CrudRepository<Sucursal, Long> {
}
