package co.edu.ucentral.proybase.controllers;

import co.edu.ucentral.proybase.entity.Cita;
import co.edu.ucentral.proybase.entity.Cliente;
import co.edu.ucentral.proybase.entity.Sucursal;
import co.edu.ucentral.proybase.services.ICitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CitaRestaController  {

    @Autowired
    private ICitaService citaService;

    public void cancelarCita(long id) {

    }

    //Override
    public Cita crearCita(Cliente cliente, Date fecha, Sucursal sucursal) {

        return null;
    }

    //Override
    public List<Cita> obtenerTodasLasCitas() {
        return null;
    }

    //@Override
    public List<Cita> obtenerCitasPorFecha(Date fecha) {
        return null;
    }

//@Override
    public List<Cita> obtenerCitasPorSucursal(String sucursal) {
        return null;
    }
}
