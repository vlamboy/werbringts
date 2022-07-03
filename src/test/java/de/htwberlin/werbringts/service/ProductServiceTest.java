package de.htwberlin.werbringts.service;

import de.htwberlin.werbringts.persistence.ProductRepository;
import de.htwberlin.werbringts.web.api.ProductManipulationRequest;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest implements WithAssertions {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductManipulationRequest productManipulationRequest;

    @InjectMocks
    private ProductService underTest;

    @Test
    @DisplayName("should return true, if delete was successful")
    void deleteProductTestTrue(){
        // Arrange
        Long id = 42L;
        doReturn(true).when(productRepository).existsById(id);

        // Act
        boolean actual = underTest.deleteById(id);

        // Assert
        verify(productRepository).deleteById(id);
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("should return false, if person to delete does not exist")
    void deleteProductTestFalse(){
        // Arrange
        Long id = 42L;
        // gib mir false zurück, wenn die Methode existsById aufgerufen wird
        doReturn(false).when(productRepository).existsById(id);

        // Act
        boolean actual = underTest.deleteById(id);

        // Assert
        // auf diesem Mock soll keine Methode mehr aufgerufen werden,
        // nach dem False soll nichts mehr passieren
        verifyNoInteractions(productRepository);
        assertThat(actual).isFalse();
    }
}
