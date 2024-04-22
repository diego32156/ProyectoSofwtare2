package co.edu.ucentral.proybase.services;

import co.edu.ucentral.proybase.entity.Cita;
import co.edu.ucentral.proybase.entity.Cliente;
import co.edu.ucentral.proybase.entity.Sucursal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CitaServiceImpl implements ICitaService {

    private List<Cita> citas;

    public CitaServiceImpl(){
        citas = new ArrayList<>();
    }

    @Override
    public void cancelarCita(long id) {
        citas.removeIf( cita -> cita.getIdCita() == id);
    }

    @Override
    public Cita crearCita(Cliente cliente, Date fecha, Sucursal sucursal) {
        Cita nuevaCita = new Cita(cliente, fecha, sucursal);
        citas.add(nuevaCita);
        return nuevaCita;
    }


    @Override
    public List<Cita> obtenerTodasLasCitas() {
        return citas;
    }

    @Override
    public List<Cita> obtenerCitasPorFecha(Date fecha) {
        List<Cita> citasPorFecha = new ArrayList<>();
        for (Cita cita : citas) {
            if (cita.getFecha().equals(fecha)) {
                citasPorFecha.add(cita);
            }
        }
        return citasPorFecha;
    }

    @Override
    public List<Cita> obtenerCitasPorSucursal(String sucursal) {
        List<Cita> citasPorSucursal = new ArrayList<>();
        for (Cita cita : citas) {
            if (cita.getSucursal().equals(sucursal)) {
                citasPorSucursal.add(cita);
            }
        }
        return citasPorSucursal;
    }

}
