package br.com.sistemaDeInventario.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sistemaDeInventario.model.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

	@Query("SELECT o FROM Order o WHERE CONCAT(o.codigoTombamento, o.tipo, o.marca, o.modelo) LIKE %?1%")
	public List<Order> search(String keyword);
}
