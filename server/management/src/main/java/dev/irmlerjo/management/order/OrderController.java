package dev.irmlerjo.management.order;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/projects")
public class OrderController {

	private final OrderRepository orderRepository;

	public OrderController(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@GetMapping("/orders")
	public List<Order> findAll() {
		return this.orderRepository.findAll();
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/orders")
	public String createOrder(@RequestBody Order order) {
		return this.orderRepository.create(order);
	}

	@GetMapping("/{projectId}/orders")
	public List<Order> findAllByProject(@PathVariable String projectId) {
		return this.orderRepository.findAllByProjectId(projectId);
	}

	@GetMapping("/orders/{id}")
	public Optional<Order> getOrderById(@PathVariable String id) {
		return this.orderRepository.findById(id);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("/orders/{id}")
	public void updateOrderById(@PathVariable String id, @RequestBody Order order) {
		if(!order.id().equals(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		this.orderRepository.update(id, order);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/orders/{id}")
	public void deleteOrderById(@PathVariable String id) {
		this.orderRepository.delete(id);
	}

}
