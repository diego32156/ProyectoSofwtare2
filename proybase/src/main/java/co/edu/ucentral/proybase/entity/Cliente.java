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
@Table(name = "clientes")

public class Cliente implements Serializable {

    @Column(name = "id_cliente")
    private long idCliente;
    private String nombre;
    private String apellido;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cedula;
    private String correoElectronico;
    private String telefono;

    @ManyToMany
    @JoinTable(
            name = "cita_clientes",
            joinColumns = @JoinColumn(name = "id_cliente"),
            inverseJoinColumns = @JoinColumn(name = "id_cita")
    )
    private Set<Cita> citas = new HashSet<>();

}
