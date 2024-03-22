package co.edu.ucentral.proybase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;



@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clientes")
@Data
@Entity
public class Clientes implements Serializable {

    @EmbeddedId
    private Long idCliente;
    @Column(nullable = false)
    private String nombre;
    private String apellido;
    private int telefono;
    private String correoElectronico;



}
