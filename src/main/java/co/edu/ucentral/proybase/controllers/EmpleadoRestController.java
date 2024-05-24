package co.edu.ucentral.proybase.controllers;

import co.edu.ucentral.proybase.entity.Empleado;
import co.edu.ucentral.proybase.services.IEmpleadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmpleadoRestController {

    @Autowired
    private IEmpleadoService empleadoService;

    @GetMapping(value = "/empleado")
    public List<Empleado> index(){
        return empleadoService.findAll();
    }

    @GetMapping(value = "/empleado/{id}")
    public ResponseEntity<?> show(@PathVariable Long id){
        Empleado empleado = null;
        Map <String, Object> response = new HashMap<>();

        try{
            empleado = empleadoService.findById(id);
        }catch (DataAccessException ex){
              response.put("mensaje","Error al realizar la consulta en la base de datos");
            response.put("mensaje",ex.getMessage().concat(" : ").concat(ex.getMostSpecificCause().getMessage()));
            return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Empleado>(empleado, HttpStatus.OK);
    }

    @PostMapping(value = "/empleado")
    public  ResponseEntity<?> create (@Valid @RequestBody Empleado empleado, BindingResult result){
        Empleado empleadoNew = null;
        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()){
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map( err -> "El Campo '"+err.getField()+"' "+ err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors",errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        try{
            empleadoNew = empleadoService.save(empleado);
        }catch (DataAccessException ex){
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("Error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El Empleado ha sido creado con exito");
        response.put("empleado", empleadoNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @PutMapping(value ="/empleado/{id}")
    public ResponseEntity<?> update(@RequestBody Empleado empleado, @PathVariable Long id){
        Empleado empleadoActual = empleadoService.findById(id);
        Empleado empleadoUpdate = null;

        Map<String, Object> response = new HashMap<>();

        if(empleadoActual == null){
            response.put("mensaje", "Error: no se pudo editar, el empleado ID:"
                    .concat(id.toString().concat(" No existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try{
            empleadoActual.setNombre(empleado.getNombre());
            empleadoActual.setApellido(empleado.getApellido());
            empleadoActual.setCedulaEmpleado(empleado.getCedulaEmpleado());
            empleadoActual.setCorreoElectronico(empleado.getCorreoElectronico());
            empleadoActual.setEstadoOcupacion(empleado.getEstadoOcupacion());
            empleadoActual.setEmpleadoCita(empleado.getEmpleadoCita());
            empleadoActual.setIdEmpleado(empleado.getIdEmpleado());

            empleadoUpdate = empleadoService.save(empleadoActual);

        }catch (DataAccessException ex){
            response.put("mensaje", "Error al actualizar el empleado en la base de datos");
            response.put("Error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        response.put("mensaje", "El Empleado ha actualizado con exito");
        response.put("empleado", empleadoUpdate);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping(value ="/empleado/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();

        try {
            empleadoService.delete(id);
        }catch (DataAccessException ex){
            response.put("mensaje", "Error al eliminar la consulta en la base de datos");
            response.put("mensaje", ex.getMessage().concat(" : ").concat(ex.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El Cliente eliminado con exito");
        return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
    }
}
