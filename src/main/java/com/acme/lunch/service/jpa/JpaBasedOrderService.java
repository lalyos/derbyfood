package com.acme.lunch.service.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import com.acme.lunch.domain.Address;
import com.acme.lunch.domain.Order;
import com.acme.lunch.domain.OrderItem;
import com.acme.lunch.domain.OrderState;
import com.acme.lunch.service.OrderService;

public class JpaBasedOrderService implements OrderService {

    private EntityManager em;
    
    public JpaBasedOrderService(EntityManager em) {
        this.em = em;
        
    }
    public OrderState doOrder(Order order) {
        em.getTransaction().begin();
        
        Address deliveryAddress = order.getDeliveryAddress();
        em.persist(deliveryAddress);
        
        List<OrderItem> items = order.getItems();
        for (OrderItem item : items) {
            item.setOrder(order);
            em.persist(item);
        }
        order.setState(OrderState.RECEIVED);
        em.persist(order);
        em.getTransaction().commit();
        
        return order.getState();
    }

    public OrderState getState(Long orderId) {
        Order order = em.find(Order.class, orderId);
        return order.getState();
    }

    public List<Order> getFullHistory() {
        
        return null;
    }

    public List<Order> getCustomerHistory(String customer) {
        List<Order> orderList = em.createNamedQuery("findAllOrdersByCustomer")
                .setParameter("customer", customer) .getResultList();
        return orderList;
    }

}
