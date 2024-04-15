package co.edu.ucentral.proybase.dao;

import co.edu.ucentral.proybase.entity.Cita;
import org.springframework.data.repository.CrudRepository;

public interface ICitaDao extends CrudRepository<Cita, Long> {
}
