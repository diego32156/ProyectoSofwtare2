package co.edu.ucentral.proybase.entity;



import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Table(name = "empleado")
@Data
@Entity
public class Empleado implements Serializable {

    @EmbeddedId
    private Long idSucursal;
    private String nombre;
    private String apellido;
    private int cedulaEmpleado;
    private boolean estadoOcupacion;


}
