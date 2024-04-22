package co.edu.ucentral.proybase.dao;

import co.edu.ucentral.proybase.entity.Empleado;
import org.springframework.data.repository.CrudRepository;

public interface IEmpleadoDao extends CrudRepository<Empleado,Long> {
}
