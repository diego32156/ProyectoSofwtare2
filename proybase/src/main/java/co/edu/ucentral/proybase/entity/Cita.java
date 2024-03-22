package co.edu.ucentral.proybase.entity;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cita")
@Data
@Entity
public class Cita  implements Serializable {

    @EmbeddedId
    private Long idCita;
    private Date fechaInico;
    private Date fechaFin;
    private String numeroCita;
    private String Descripcion;



}
