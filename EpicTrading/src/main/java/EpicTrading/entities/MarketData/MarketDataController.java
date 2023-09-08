package EpicTrading.entities.MarketData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marketData")
public class MarketDataController {
	@Autowired
	MarketDataService mS;

//	@PostMapping("")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Order saveOrder(@RequestBody NewOrderPayload body) {
//		Order createdOrder = mS(body);
//		return createdOrder;
//	}

//	@GetMapping("")
//	public List<MarketData> getMarketData() {
//		return mS.getAllMarketData();
//	}
	@GetMapping("")
	public Page<MarketData> getMarketData(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "id") String order) {
		return mS.getAllMarketData(page, order);
	}
//
//	@GetMapping("/{orderId}")
//	public Order findById(@PathVariable UUID orderId) {
//		return oS.getOrderById(orderId);
//	}
//
//	@PutMapping("/{userId}")
//	public User updateUser(@PathVariable UUID userId, @RequestBody NewUserPayload body) {
//		return oS.findByIdAndUpdate(userId, body);
//	}

//	@DeleteMapping("/{userId}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public void deleteUser(@PathVariable UUID userId) {
//		oS.(userId);
//	}

}