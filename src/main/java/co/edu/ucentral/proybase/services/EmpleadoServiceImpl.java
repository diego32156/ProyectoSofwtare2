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
        return (List<Empleado>) empleadoDao.findAll();
    }

    @Override
    public Empleado findById(Long id) {
        return empleadoDao.findById(id).orElse(null);
    }

    @Override
    public Empleado save(Empleado empleado) {
        return empleadoDao.save(empleado);
    }

    @Override
    public void delete(Long id) {
        empleadoDao.deleteById(id);
    }
}
