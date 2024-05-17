package co.edu.ucentral.proybase.services;

import co.edu.ucentral.proybase.entity.Cliente;
import co.edu.ucentral.proybase.entity.Sucursal;
import java.util.List;
public interface ISucursalService {

    public List <Sucursal> findAll();

    public Sucursal findById(Long id);

    public Sucursal save (Sucursal sucursal);

    public void delete (Long id);

}
