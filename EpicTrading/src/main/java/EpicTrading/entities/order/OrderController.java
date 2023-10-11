package EpicTrading.entities.order;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	OrderService oS;

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Order saveOrder(@RequestBody NewOrderPayload body) {
		Order createdOrder = oS.createOrder(body);
		return createdOrder;
	}

	@GetMapping("")
	public List<Order> getOrders() {
		return oS.getAllOrders();
	}

	@GetMapping("/{orderId}")
	public Order findById(@PathVariable UUID orderId) {
		return oS.getOrderById(orderId);
	}

}
