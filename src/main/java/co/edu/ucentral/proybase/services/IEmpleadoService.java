package co.edu.ucentral.proybase.services;



import co.edu.ucentral.proybase.entity.Empleado;


import java.util.List;

public interface IEmpleadoService {

    public List <Empleado> findAll();

    public Empleado findById(Long id);

    public Empleado save (Empleado empleado);

    public void delete (Long id);


}
