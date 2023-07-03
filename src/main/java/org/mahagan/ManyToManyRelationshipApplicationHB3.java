package org.mahagan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.mahagan.model.Orders;
import org.mahagan.model.Products;

public class ManyToManyRelationshipApplicationHB3 {
    public static void main(String[] args) {
        StandardServiceRegistry ssr =new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = metadata.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction tsx = session.beginTransaction();

        Orders orders = new Orders();
        orders.setEmpFirstName("Krishna");
        orders.setEmpLastName("Shinde");
        orders.setEmpAddress("Pune");
        orders.setPincode(412207);
        orders.setDate("12-Dec-2022");

        Products products = new Products();
        products.setProductName("Airpod");
        products.setProductDescription("Wireless airpod 42Hr batary backup");
        products.setProductCost(1099);

        orders.getProducts().add(products);
        products.getOrders().add(orders);

        session.persist(orders);
        tsx.commit();
        session.close();

        System.out.println("Data Inserted in Table");
    }
}