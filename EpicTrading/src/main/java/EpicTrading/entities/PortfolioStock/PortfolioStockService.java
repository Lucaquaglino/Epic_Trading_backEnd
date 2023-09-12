package EpicTrading.entities.PortfolioStock;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PortfolioStockService {

	@Autowired
	private PortfolioStockRepository pR;

//	public Page<PortfolioStock> findAll(int page, String sort) {
//		Pageable pageable = PageRequest.of(page, 20, Sort.by(sort));
//		return pR.findAll(pageable);
//	}

	public Page<PortfolioStock> findByUserId(int page, String sort, UUID userId) {
		Pageable pageable = PageRequest.of(page, 60, Sort.by(sort));
		return pR.findByUserId(userId, pageable);
	}

}
