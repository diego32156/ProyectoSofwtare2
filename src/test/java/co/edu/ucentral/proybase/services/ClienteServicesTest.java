package co.edu.ucentral.proybase.services;

import co.edu.ucentral.proybase.dao.IClienteDao;
import co.edu.ucentral.proybase.entity.Cita;
import co.edu.ucentral.proybase.entity.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
 class ClienteServicesTest {

    private Cliente cliente;
    private Cita cita;


    @InjectMocks
    ClienteServiceImpl clienteServiceimpl;

    @Mock
    IClienteService clienteService;

    @BeforeEach
    void setup(){
        
    }

}
