package co.edu.ucentral.proybase.services;

import co.edu.ucentral.proybase.entity.Cita;
import co.edu.ucentral.proybase.entity.Empleado;

import java.util.List;

public interface IEmpleadoService {


    public void acpetarCita(Cita cita, Empleado empleado);

    public List<Cita> verCitas(Empleado empleado);

    public void realizarDescripcion(Cita cita, Empleado empleado, String descripcion);


}
