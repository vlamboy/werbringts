package de.htwberlin.werbringts.web;

import de.htwberlin.werbringts.service.ProductService;
import de.htwberlin.werbringts.web.api.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductRestController.class)
public class ProductRestControllerTest {

    @Autowired
    private MockMvc mockmvc;

    @MockBean
    private ProductService productService;

    @Test
    @DisplayName("should return the right product from person service")
    void getProductTest() throws Exception {
        // Arrange
        var products = List.of(
                new Product(1, "Tomaten", 50,false, 11, Collections.emptyList()),
                new Product(2, "Sekt", 10, false, 11, Collections.emptyList())
        );
        doReturn(products).when(productService).findAll();
        // Act
        mockmvc.perform(get("/api/v1/products"))
        // Assert
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].productId").value("1"))
                .andExpect(jsonPath("$[0].productName").value("Tomaten"))
                .andExpect(jsonPath("$[0].quantity").value(50))
                .andExpect(jsonPath("$[0].closed").value(false))

                .andExpect(jsonPath("$[1].productId").value("2"))
                .andExpect(jsonPath("$[1].productName").value("Sekt"))
                .andExpect(jsonPath("$[1].quantity").value(10))
                .andExpect(jsonPath("$[1].closed").value(false));
    }

    @Test
    @DisplayName("should return 404, when product that should be deleted doesn't exist")
    void deleteProductTest() throws Exception {
        // Arrange
        doReturn(null).when(productService).deleteById(anyLong());
        // Act
        mockmvc.perform(delete("/api/v1/products/42"))
        // Assert
                .andExpect(status().isNotFound());
    }
}
