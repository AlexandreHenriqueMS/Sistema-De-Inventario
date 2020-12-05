package br.com.sistemaDeInventario;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import br.com.sistemaDeInventario.model.entities.Order;
import br.com.sistemaDeInventario.model.repositories.OrderRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class OrderRepositoryTests {

	@Autowired
	private OrderRepository repo;
	
	@Autowired
	private TestEntityManager entityTest;
	
	@Test
	private void testCreateOrder() {
		Order order = new Order();
		order.setCep("54230100");
		order.setCliente("Alexandre Henrique");
		order.setDataTombamento(Instant.now());
		order.setMarca("Lenovo");
		order.setModelo("Legion Y720");
		order.setTipo("Notebook");
		order.setNota("é o melhor notebook Lenovo da nossa lista!");
		order.setQuantidade(1);
		order.setUltimaMovimentacao(Instant.now());
		
		Order orderSaved = repo.save(order);
		
		Order existOrder = entityTest.find(Order.class, orderSaved.getCodigoTombamento());
		
		assertThat(existOrder.getCliente()).isEqualTo(order.getCliente());
	}
}
