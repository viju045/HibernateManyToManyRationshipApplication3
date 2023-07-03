package org.mahagan.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class ProductsTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Products}
     *   <li>{@link Products#setOrders(Set)}
     *   <li>{@link Products#setProductCost(int)}
     *   <li>{@link Products#setProductDescription(String)}
     *   <li>{@link Products#setProductId(int)}
     *   <li>{@link Products#setProductName(String)}
     *   <li>{@link Products#getOrders()}
     *   <li>{@link Products#getProductCost()}
     *   <li>{@link Products#getProductDescription()}
     *   <li>{@link Products#getProductId()}
     *   <li>{@link Products#getProductName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Products actualProducts = new Products();
        HashSet<Orders> orders = new HashSet<>();
        actualProducts.setOrders(orders);
        actualProducts.setProductCost(1);
        actualProducts.setProductDescription("Product Description");
        actualProducts.setProductId(1);
        actualProducts.setProductName("Product Name");
        assertSame(orders, actualProducts.getOrders());
        assertEquals(1, actualProducts.getProductCost());
        assertEquals("Product Description", actualProducts.getProductDescription());
        assertEquals(1, actualProducts.getProductId());
        assertEquals("Product Name", actualProducts.getProductName());
    }
}

