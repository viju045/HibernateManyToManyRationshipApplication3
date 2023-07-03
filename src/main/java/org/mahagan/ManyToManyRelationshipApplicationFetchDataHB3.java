/**
 * Created By VijayKumar Moohite
 * Date : 7/3/2023
 * Time : 2:25 PM
 * Project : ManyToManyRelationshipApplicationHB3
 **/

package org.mahagan;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.mahagan.model.Orders;
import org.mahagan.model.Products;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ManyToManyRelationshipApplicationFetchDataHB3 {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = metadata.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction tsx = session.beginTransaction();

        TypedQuery query = session.createQuery("From Orders orders");
        List<Orders> list = query.getResultList();
        Iterator<Orders> iterator = list.listIterator();

        while(iterator.hasNext())
        {
            Orders orders = iterator.next();
            System.out.println("Orders Details>>>>>>>>>>>>>"+orders.getEmpFirstName()+" "+orders.getEmpLastName()+" "+orders.getEmpAddress()+" "+orders.getPincode()+" "+orders.getDate());

            Set<Products> set = orders.getProducts();
            Iterator<Products>iterator1 = set.iterator();
            while(iterator1.hasNext())
            {
                Products products = iterator1.next();
                System.out.println("Products Details>>>>>>>>>>>>>"+products.getProductName()+" "+products.getProductDescription()+" "+products.getProductCost());
            }

        }
        session.close();
        System.out.println("Data Fetch Successfully");
    }
}
