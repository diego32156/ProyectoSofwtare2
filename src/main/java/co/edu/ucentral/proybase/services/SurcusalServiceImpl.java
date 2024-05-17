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


    @Override
    public List<Sucursal> findAll() {
        return (List<Sucursal>) sucursalDao.findAll();
    }

    @Override
    public Sucursal findById(Long id) {
        return sucursalDao.findById(id).orElse(null);
    }

    @Override
    public Sucursal save(Sucursal sucursal) {
        return sucursalDao.save(sucursal);
    }

    @Override
    public void delete(Long id) {
        sucursalDao.deleteById(id);
    }
}
