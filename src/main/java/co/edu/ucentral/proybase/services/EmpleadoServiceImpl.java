package co.edu.ucentral.proybase.services;

import co.edu.ucentral.proybase.dao.IEmpleadoDao;
import co.edu.ucentral.proybase.entity.Cita;
import co.edu.ucentral.proybase.entity.Empleado;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

    private IEmpleadoDao empleadoDao;


    @Override
    public List<Empleado> findAll() {
        return null;
    }

    @Override
    public Empleado findById(Long id) {
        return null;
    }

    @Override
    public Empleado save(Empleado empleado) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
