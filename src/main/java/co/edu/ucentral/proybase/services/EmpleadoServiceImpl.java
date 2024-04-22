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
    public void acpetarCita(Cita cita, Empleado empleado) {
        return ;
    }

    @Override
    public List<Cita> verCitas(Empleado empleado) {
        return null;
    }

    @Override
    public void realizarDescripcion(Cita cita, Empleado empleado, String descripcion) {

    }

}
