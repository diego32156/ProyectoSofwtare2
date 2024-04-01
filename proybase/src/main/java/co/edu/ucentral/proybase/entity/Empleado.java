package co.edu.ucentral.proybase.entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "empleado")
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private long idEmpleado ;
    private String nombre;
    private String apellido;
    @Column(name = "cedula_empleado")
    private int cedulaEmpleado;
    @Column(name = "estado_ocupacion")
    private boolean estadoOcupacion;

    @OneToMany
    @JoinTable(
            name = "empleado_cita",
            joinColumns = @JoinColumn(name = "id_empleado"),
            inverseJoinColumns = @JoinColumn(name = "id_cita")
    )
    private Set<Cita> citasEmpelado = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "empleado_cita",
            joinColumns = @JoinColumn(name = "id_empleado"),
            inverseJoinColumns = @JoinColumn(name = "id_tipoCita")
    )
    private Set<TipoCita> empleadotipoCita = new HashSet<>();

}
