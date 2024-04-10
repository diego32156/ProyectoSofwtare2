package co.edu.ucentral.proybase.controllers;

import co.edu.ucentral.proybase.entity.Clientes;
import co.edu.ucentral.proybase.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public  class ClienteRestController  {

    @Autowired
    private IClienteService clienteService;
    @GetMapping("/clientes")
    public List<Clientes> index() {
        return clienteService.findAll();
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        Clientes cliente = null;
        Map <String, Object> response = new HashMap<>();
        try{
         cliente = clienteService.findById(id);
        } catch (DataAccessException ex){
            response.put("mensaje","Error al realizar la consulta en la base de datos");
            response.put("mensaje",ex.getMessage().concat(" : ").concat(ex.getMostSpecificCause().getMessage()));
            return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Clientes>(cliente,HttpStatus.OK);
    }


    @PostMapping("/clientes")
    public ResponseEntity<?> create(@Valid @RequestBody Clientes cliente, BindingResult result) {
        Clientes clienteNew = null;
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
            clienteNew = clienteService.save(cliente);
        }catch (DataAccessException ex){
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("Error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El cliente ha sido creado con exito");
        response.put("cliente", clienteNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<?> update(@RequestBody Clientes cliente, @PathVariable Long id){
        Clientes clienteActual = clienteService.findById(id);
        Clientes clienteUpdate = null;


        return null;
    }

    @DeleteMapping("/clientes/{id}")
    public  ResponseEntity<?> delete (@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            clienteService.delete(id);

        }catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar la consulta en la base de datos");
            response.put("mensaje", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El Cliente eliminado con exito");
        return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);

    }
}
