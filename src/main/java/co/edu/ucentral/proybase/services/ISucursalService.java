package co.edu.ucentral.proybase.services;

import co.edu.ucentral.proybase.entity.Sucursal;
import java.util.List;
public interface ISucursalService {

    public List<Sucursal> obtenerTodasSucursales();

    public Sucursal obtenerSucursalporid(long id);

    public  void agregarSucursal(Sucursal sucursal);

    public void actualizarSucursal (Sucursal sucursal);

    public void  eliminarSucursal (long id);

}
