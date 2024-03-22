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
@Table(name = "sucursal")
@Data
@Entity
public class Sucursal implements Serializable {

    @EmbeddedId
    private Long idSucursal;
    private String direccion;
    private int telefono;



}
