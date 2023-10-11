package EpicTrading.entities.MarketData;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marketData")
public class MarketDataController {
	@Autowired
	MarketDataService mS;

	@GetMapping("")
	public Page<MarketData> getMarketData(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "id") String order) {
		return mS.getAllMarketData(page, order);
	}

	@GetMapping("/{userId}")
	public MarketData findById(@PathVariable UUID userId) {
		return mS.findById(userId);
	}

}