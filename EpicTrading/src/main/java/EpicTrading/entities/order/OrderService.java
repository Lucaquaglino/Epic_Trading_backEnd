package EpicTrading.entities.order;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EpicTrading.exceptions.NotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public Order createOrder(NewOrderPayload body) {
		Order newOrder = new Order(body.getTimeStamp(), body.getQuantity(), body.getOrderType(), body.getMarketData());

		return orderRepository.save(newOrder);
	}

	public Order getOrderById(UUID id) throws NotFoundException {
		return orderRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

}