package org.mahagan.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class OrdersTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Orders}
     *   <li>{@link Orders#setDate(String)}
     *   <li>{@link Orders#setEmpAddress(String)}
     *   <li>{@link Orders#setEmpFirstName(String)}
     *   <li>{@link Orders#setEmpLastName(String)}
     *   <li>{@link Orders#setOrderId(int)}
     *   <li>{@link Orders#setPincode(int)}
     *   <li>{@link Orders#setProducts(Set)}
     *   <li>{@link Orders#getDate()}
     *   <li>{@link Orders#getEmpAddress()}
     *   <li>{@link Orders#getEmpFirstName()}
     *   <li>{@link Orders#getEmpLastName()}
     *   <li>{@link Orders#getOrderId()}
     *   <li>{@link Orders#getPincode()}
     *   <li>{@link Orders#getProducts()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Orders actualOrders = new Orders();
        actualOrders.setDate("2020-03-01");
        actualOrders.setEmpAddress("42 Main St");
        actualOrders.setEmpFirstName("Jane");
        actualOrders.setEmpLastName("Doe");
        actualOrders.setOrderId(1);
        actualOrders.setPincode(1);
        HashSet<Products> products = new HashSet<>();
        actualOrders.setProducts(products);
        assertEquals("2020-03-01", actualOrders.getDate());
        assertEquals("42 Main St", actualOrders.getEmpAddress());
        assertEquals("Jane", actualOrders.getEmpFirstName());
        assertEquals("Doe", actualOrders.getEmpLastName());
        assertEquals(1, actualOrders.getOrderId());
        assertEquals(1, actualOrders.getPincode());
        assertSame(products, actualOrders.getProducts());
    }
}

