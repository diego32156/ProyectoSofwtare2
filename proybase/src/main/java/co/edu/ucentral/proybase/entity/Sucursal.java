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
@Table(name = "sucursal")
public class Sucursal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sucursal")
    private long idSucursal;
    private String direccion;
    private int telefono;

     @ManyToOne
     @JoinTable(
             name = "sucursal_tipoCita",
             joinColumns = @JoinColumn(name = "id_sucursal"),
             inverseJoinColumns = @JoinColumn(name = "id_tipoCita")
     )
     private Set<TipoCita> sucursalTipoDeCita = new HashSet<>();





}
