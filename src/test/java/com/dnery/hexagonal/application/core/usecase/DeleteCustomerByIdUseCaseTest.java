package com.dnery.hexagonal.application.core.usecase;

import com.dnery.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.dnery.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeleteCustomerByIdUseCaseTest {

    @Mock
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Mock
    private DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

    @InjectMocks
    private DeleteCustomerByIdUseCase deleteCustomerByIdUseCase;

    @Test
    void deveBuscarEDepoisDeletarOCliente() {
        String id = "123";

        deleteCustomerByIdUseCase.delete(id);

        InOrder ordem = inOrder(findCustomerByIdInputPort, deleteCustomerByIdOutputPort);
        ordem.verify(findCustomerByIdInputPort).find(id);
        ordem.verify(deleteCustomerByIdOutputPort).delete(id);
    }

    @Test
    void naoDeveDeletarQuandoClienteNaoExiste() {
        String id = "999";
        doThrow(new RuntimeException("Cliente não encontrado"))
                .when(findCustomerByIdInputPort).find(id);

        assertThrows(RuntimeException.class, () -> deleteCustomerByIdUseCase.delete(id));

        verify(deleteCustomerByIdOutputPort, never()).delete(anyString());
    }
}