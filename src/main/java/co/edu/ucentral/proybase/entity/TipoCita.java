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
@Table(name = "tipo_cita")
public class TipoCita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipoCita")
    private long idTipoCita;

    @Column(name = "tipo_de_servicio")
    private String tipoDeServicio;

    @OneToMany(mappedBy = "tipoCita")
    private Set<Sucursal> citaSucursal = new HashSet<>();
}
