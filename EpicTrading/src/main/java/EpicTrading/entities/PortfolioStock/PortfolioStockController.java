package EpicTrading.entities.PortfolioStock;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolioStock")
public class PortfolioStockController {

	@Autowired
	private PortfolioStockService pS;

	@GetMapping("/{userId}")
	public Page<PortfolioStock> findByUserId(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "id") String order, @PathVariable UUID userId) {
		return pS.findByUserId(page, order, userId);
	}

}
