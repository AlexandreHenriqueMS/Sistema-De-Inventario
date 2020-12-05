package br.com.sistemaDeInventario.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemaDeInventario.model.entities.Order;
import br.com.sistemaDeInventario.model.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;
	
	public List<Order> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }
	
	public Order findById(Long id) {
		return repo.findById(id).get();
	}
	
	public void save(Order order) {
		repo.save(order);
	}
}
