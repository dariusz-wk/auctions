package pl.edu.agh.eaiib.auctions.job;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.edu.agh.eaiib.auctions.DBCleanerBean;
import pl.edu.agh.eaiib.auctions.service.AuctionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-config.xml", "/task-test-config.xml" })
public class FlinishAuctionTaskTest {
	@Autowired
	FinishAuctionTask task;
	@Autowired
	DBCleanerBean dbCleanerBean;
	@Autowired
	AuctionService auctionService;

	@Test
	public void test() {
		Assert.assertFalse(auctionService.findToFinish().isEmpty());
		task.run(null);
		Assert.assertTrue(auctionService.findToFinish().isEmpty());
	}

	@After
	public void clean() {
		dbCleanerBean.clean();
	}
}
