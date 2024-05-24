package co.edu.ucentral.proybase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sucursal")
public class Sucursal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sucursal")
    private long idSucursal;

    private String direccion;
    private String nombre;
    private int telefono;

    @OneToMany
    @JoinTable(
            name = "sucursal_tipoCita",
            joinColumns = @JoinColumn(name = "id_surcusal"),
            inverseJoinColumns = @JoinColumn(name = "id_tipoCita")
    )
    private List<TipoCita> tipoCitas = new ArrayList<>();
}
