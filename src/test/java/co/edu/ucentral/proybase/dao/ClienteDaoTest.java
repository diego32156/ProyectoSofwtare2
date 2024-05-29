package co.edu.ucentral.proybase.dao;

import co.edu.ucentral.proybase.entity.Cliente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
 class ClienteDaoTest {


    @Autowired
    IClienteDao clienteDao;

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    private TestEntityManager testEntityManager;

    @DisplayName( value = "Test de crear cliente Bancario")
    @Test
    void testCrearCliente(){
        Cliente cliente = Cliente
                .builder()
                .nombre("Cristian")
                .apellido("Gonzalez")
                .cedula(1256489870)
                .correoElectronico("cristangonzales@yopmail.com")
                .telefono("3204879523")
                .build();

        Cliente cliente1 =  clienteDao.save(cliente);

        assertThat(cliente1).isNotNull();
        assertThat(cliente1.getCedula()).isGreaterThan(0);
    }
}
