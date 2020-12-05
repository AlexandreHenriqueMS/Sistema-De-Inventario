package br.com.sistemaDeInventario.controller;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.sistemaDeInventario.model.entities.Order;
import br.com.sistemaDeInventario.model.service.OrderService;

@Controller
public class AppController {
	
	@Autowired
	private OrderService service;

	@RequestMapping(value = { "", "/", "/home" }, method = RequestMethod.GET)
	public String Home() {
		return "index";
	}

	@RequestMapping(value = "/inventario", method = RequestMethod.GET)
	public String Inventario(Model model, @Param("keyword") String keyword) {
		List<Order> listPedidos = service.listAll(keyword);
        model.addAttribute("listPedidos", listPedidos);
        model.addAttribute("keyword", keyword);
         
		return "inventario";
	}

	@RequestMapping(value = "/sobre", method = RequestMethod.GET)
	public String sobre() {

		return "sobre";
	}

	@RequestMapping(value = "/tombamento", method = RequestMethod.GET)
	public String tombamento(Model model) {
		model.addAttribute("order", new Order());
		return "tombamento";
	}
	
	@RequestMapping(value = "/tombamento", method = RequestMethod.POST)
	public String tombamentoRegister(Order order) {
		order.setCliente(order.getCliente());
		order.setMarca(order.getMarca());
		order.setModelo(order.getModelo());
		order.setTipo(order.getTipo());
		order.setUltimaMovimentacao(Instant.now().minus(3, ChronoUnit.HOURS));
		order.setDataTombamento(Instant.now().minus(3, ChronoUnit.HOURS));
		service.save(order);
		return "index";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String tombamentoUpdate(Model model,@PathVariable(name = "id")Long id) {
		Order orderUpdate = service.findById(id); 
		model.addAttribute("order", orderUpdate);
		return "update";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView tombamentoUpdateRegister(@ModelAttribute("order") Order order) {
		ModelAndView mv = new ModelAndView("index");
		order.setCliente(order.getCliente());
		order.setMarca(order.getMarca());
		order.setModelo(order.getModelo());
		order.setTipo(order.getTipo());
		order.setUltimaMovimentacao(Instant.now().minus(3, ChronoUnit.HOURS));
		service.save(order);
		return mv;
	}
}
