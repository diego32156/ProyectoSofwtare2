package co.edu.ucentral.proybase.controllers;

import co.edu.ucentral.proybase.entity.Sucursal;
import co.edu.ucentral.proybase.services.ISucursalService;
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
public class SucursalRestController {


    @Autowired
    private ISucursalService sucursalService;


    @GetMapping(value = "/sucursal")
    public List<Sucursal> index(){
        return sucursalService.findAll();
    }

    @GetMapping(value = "/sucursal/{id}")
    public ResponseEntity<?> show(@PathVariable Long id){
        Sucursal sucursal = null;
        Map<String, Object> response = new HashMap<>();

        try{
            sucursal = sucursalService.findById(id);
        } catch (DataAccessException ex){
            response.put("mensaje","Error al realizar la consulta en la base de datos");
            response.put("mensaje",ex.getMessage()
                    .concat(" : ").concat(ex.getMostSpecificCause().getMessage()));
            return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Sucursal>(sucursal,HttpStatus.OK);
    }

    @PostMapping(value = "/sucursal")
    public ResponseEntity<?> create(@Valid @RequestBody Sucursal sucursal, BindingResult result){
        Sucursal sucursalNew = null;
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
            sucursalNew = sucursalService.save(sucursal);
        }catch (DataAccessException ex){
            response.put("mensaje","Error al realizar el insert  en la base de datos");
            response.put("mensaje",ex.getMessage()
                    .concat(" : ").concat(ex.getMostSpecificCause().getMessage()));
            return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "la sucursal se creado con exito");
        response.put("sucursal",sucursalNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping(value ="/sucursal/{id}")
    public ResponseEntity<?> update(@RequestBody Sucursal sucursal, @PathVariable Long id){
        Sucursal sucursalActual = sucursalService.findById(id);
        Sucursal sucursalUpdate = null;

        Map<String, Object> response = new HashMap<>();

        if(sucursalActual == null){
            response.put("mensaje", "Error: no se pudo editar, la sucursal ID:"
                    .concat(id.toString().concat(" No existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try{
            sucursalActual.setNombre(sucursal.getNombre());
            sucursalActual.setDireccion(sucursal.getDireccion());
            sucursalActual.setTelefono(sucursal.getTelefono());
            sucursalActual.setIdSucursal(sucursal.getIdSucursal());
            sucursalActual.setTipoCitas(sucursal.getTipoCitas());

            sucursalUpdate = sucursalService.save(sucursalActual);
        } catch (DataAccessException ex){
            response.put("mensaje","Error al realizar al actualizar  la base de datos");
            response.put("mensaje",ex.getMessage()
                    .concat(" : ").concat(ex.getMostSpecificCause().getMessage()));
            return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "la sucursal se actualizado con exito");
        response.put("sucursal",sucursalUpdate);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping(value ="/cliente /{id}")
    public  ResponseEntity<?> delete (@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();

        try{
            sucursalService.delete(id);
        }catch (DataAccessException ex){
            response.put("mensaje","Error al eliminar la sucursal de  la base de datos");
            response.put("mensaje",ex.getMessage()
                    .concat(" : ").concat(ex.getMostSpecificCause().getMessage()));
            return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El Cliente eliminado con exito");
        return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
    }


}
