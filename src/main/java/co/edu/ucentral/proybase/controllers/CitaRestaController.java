package co.edu.ucentral.proybase.controllers;

import co.edu.ucentral.proybase.entity.Cita;
import co.edu.ucentral.proybase.services.ICitaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CitaRestaController  {

    @Autowired
    private ICitaService citaService;

    @GetMapping(value = "/cita")
    public List<Cita> index(){
        return  citaService.findAll();
    }

    @GetMapping(value="/cita/{id}")
    public ResponseEntity<?> show(@PathVariable Long id){
        Cita cita = null;
        Map<String, Object> response = new HashMap<>();

        try{
            cita = citaService.findById(id);
        }catch (DataAccessException ex){
            response.put("mensaje", "Error ala realizar la consulta en la base de datos");
            response.put("mensaje", ex.getMessage().concat(" : ")
                    .concat(ex.getMostSpecificCause().getMessage()));
            return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Cita>(cita, HttpStatus.OK);
    }

    @PostMapping(value ="/cita")
    public ResponseEntity<?> create(@Valid @RequestBody Cita cita, BindingResult result){
        Cita citaNew = null;
        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()){
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() +"' "+err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try{
            citaNew = citaService.save(cita);
        } catch (DataAccessException ex){
            response.put("mensaje", "Error ala realizar el insert de la cita  en la base de datos");
            response.put("mensaje", ex.getMessage().concat(" : ")
                    .concat(ex.getMostSpecificCause().getMessage()));
            return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "La cita bancaria se ha creado con exito");
        response.put("cita", citaNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping(value = "/cita/{id}")
    public ResponseEntity<?> update(@RequestBody Cita cita, @PathVariable Long id){
        Cita citaActual = citaService.findById(id);
        Cita citaUpdate = null;

        Map<String, Object> response = new HashMap<>();

        if(citaActual == null){
            response.put("mensaje", "Error: no se pudo editar, el cliente ID:"
                    .concat(id.toString().concat(" No existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {
            citaActual.setDescripcion(cita.getDescripcion());
            citaActual.setNumeroCita(cita.getNumeroCita());
            citaActual.setDescripcion(cita.getDescripcion());
            citaActual.setFecha(cita.getFecha());
            citaActual.setCliente(cita.getCliente());
            citaActual.setEmpleado(cita.getEmpleado());
            citaActual.setSucursal(cita.getSucursal());
            citaActual.setIdCita(cita.getIdCita());

            citaUpdate = citaService.save(citaActual);
        }catch (DataAccessException ex){
            response.put("mensaje", "Error a realizar la actualización  de la cita  en la base de datos");
            response.put("mensaje", ex.getMessage().concat(" : ")
                    .concat(ex.getMostSpecificCause().getMessage()));
            return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "La cita bancaria se ha creado con exito");
        response.put("cita", citaUpdate);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping(value ="/cita/{id}")
    public  ResponseEntity<?> delete (@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try{
            citaService.delete(id);
        } catch (DataAccessException ex){
            response.put("mensaje", "Error a realizar la actualización  de la cita  en la base de datos");
            response.put("mensaje", ex.getMessage().concat(" : ")
                    .concat(ex.getMostSpecificCause().getMessage()));
            return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje","la cita se a eliminado con exito");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
