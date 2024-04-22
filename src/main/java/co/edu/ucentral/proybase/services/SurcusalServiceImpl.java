package co.edu.ucentral.proybase.services;


import co.edu.ucentral.proybase.dao.ISucursalDao;
import co.edu.ucentral.proybase.entity.Sucursal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SurcusalServiceImpl  implements ISucursalService {

    private ISucursalDao sucursalDao;

    private Map<Integer, Sucursal> sucursales;    

    public SurcusalServiceImpl(){
        this.sucursales = new HashMap<>();
        agregarSucursal(new Sucursal(1, "Direccion 123", "Sucursal Central", 32165487));
    }

    @Override
    public List<Sucursal> obtenerTodasSucursales() {
        return new ArrayList<>(sucursales.values());

    }

    @Override
    public Sucursal obtenerSucursalporid(long id) {
        return sucursales.get(id);
    }

    @Override
    public void agregarSucursal(Sucursal sucursal) {
        sucursalDao.save(sucursal);
    }

    @Override
    public void actualizarSucursal(Sucursal sucursal) {
        if (sucursales.containsKey(sucursal.getIdSucursal())) {
            sucursalDao.save(sucursal);
        } else {
            throw new IllegalArgumentException("La sucursal no existe");
        }
    }

    @Override
    public void eliminarSucursal(long id) {
        sucursalDao.deleteById(id);
    }
}
