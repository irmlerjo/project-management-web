package dev.irmlerjo.management.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Repository;

import dev.irmlerjo.management.costreport.FixedPriceCostReport;
import dev.irmlerjo.management.costreport.PerHourCostReport;
import jakarta.annotation.PostConstruct;

@Repository
public class OrderRepository {

	List<Order> orders = new ArrayList<>();

	List<Order> findAll() {
		return this.orders;
	}

	@PostConstruct
	private void init() {
		this.orders.add(new Order("1", "1", "Duva NWS First Sprint",
				"First sprint of the Duva NWS System. Supposed to take about two weeks to finish.",
				new FixedPriceCostReport(100000), null, LocalDateTime.now(), 60));
		this.orders.add(new Order("2", "1", "Duva NWS Second Sprint",
				"First sprint of the Duva NWS System. Supposed to take about two weeks to finish.",
				new FixedPriceCostReport(100000), null, LocalDateTime.now(), 100));
		this.orders.add(new Order("3", "2", "Expertsystem Development", "Development of the entire expertsystem.", null,
				new PerHourCostReport(100), LocalDateTime.now(), 100));
		this.orders
				.add(new Order("4", "3", "GIS Development", "Integration of the GIS System in the new web application.",
						null, new PerHourCostReport(100), LocalDateTime.now(), 300));
	}

	public Optional<Order> findById(String id) {
		return this.orders.stream().filter(order -> order.id().equals(id)).findFirst();
	}

	public void update(String id, Order updatedOrder) {
		Optional<Order> currentOrder = findById(id);
		if (currentOrder.isPresent()) {
			this.orders.set(this.orders.indexOf(currentOrder.get()), updatedOrder);
		}
	}

	public String create(Order newOrder) {
		String newId = this.generateId();
		Order newOrderWithId = new Order(newId, newOrder);
		this.orders.add(newOrderWithId);
		return newId;
	}

	// TODO Provisional. Does not check for collisions.
	private String generateId() {
		return Integer.toString(new Random().nextInt());
	}

	public List<Order> findAllByProjectId(String projectId) {
		return this.orders.stream().filter(order -> order.projectId().equals(projectId)).toList();

	}

	public void delete(String id) {
		Optional<Order> toDelete = this.findById(id);
		if (toDelete.isPresent()) {
			this.orders.remove(this.orders.indexOf(toDelete.get()));
		}
	}

}
