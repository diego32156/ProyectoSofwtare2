package co.edu.ucentral.proybase.services;

import co.edu.ucentral.proybase.entity.Cita;
import co.edu.ucentral.proybase.entity.Cliente;
import co.edu.ucentral.proybase.entity.Sucursal;

import java.util.Date;
import java.util.List;

public interface ICitaService {
    public void cancelarCita(long id);

   public Cita crearCita(Cliente cliente, Date fecha, Sucursal sucursal);

    public List<Cita> obtenerTodasLasCitas();

    // Método para obtener citas por fecha
   public List<Cita> obtenerCitasPorFecha(Date fecha);

    // Método para obtener citas por sucursal
    public List<Cita> obtenerCitasPorSucursal(String sucursal);

}
