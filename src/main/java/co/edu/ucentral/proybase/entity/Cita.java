package co.edu.ucentral.proybase.entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;



@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cita")
public class Cita  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCita;
    private Date fecha;
    private String numeroCita;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idSucursal")
    private Sucursal sucursal;

    @OneToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

}
