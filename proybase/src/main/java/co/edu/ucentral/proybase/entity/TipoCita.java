package co.edu.ucentral.proybase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tipo-cita")
public class TipoCita implements Serializable {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id_tipoCita")
     private long idTipoCita;
     @Column(name = "tipo_de_servicio")
     private String tipoDeServicio;

   //  @OneToMany(mappedBy = "sucursal") // Corregido el nombre del atributo en Sucursal
   //  private Set<Sucursal> cita_sucursal = new HashSet<>();

}
