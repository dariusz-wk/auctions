package pl.edu.agh.eaiib.auctions.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mortbay.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.edu.agh.eaiib.auctions.model.Auction;
import pl.edu.agh.eaiib.auctions.service.AuctionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-config.xml", "/auction-service-test-config.xml" })
public class AuctionServiceTest {
	@Autowired
	AuctionService auctionService;

	Logger log = Logger.getLogger(getClass());

	@Test
	public void test1() {
		log.debug("AUCTION SERVICE TEST");
		Assert.assertNotNull(auctionService);

		// find all
		Assert.assertEquals(5, auctionService.find(null, null, null, null, null, null, null).size());
		List<Auction> list = auctionService.find(null, null, null, null, null, null, null);
		log.debug(list);
		
		// find by title
		Assert.assertEquals(1, auctionService.find("ROLMEX", null, null, null, null, null, null).size());

		// find all finished
		Assert.assertEquals(1, auctionService.find(null, true, null, null, null, null, null).size());

		// find all finazlize
		Assert.assertEquals(0, auctionService.find(null, null, true, null, null, null, null).size());

		// find all with bet from client
		Assert.assertEquals(1, auctionService.find(null, null, null, null, "client2", null, null).size());

		// find all for menager
		Assert.assertEquals(5, auctionService.find(null, null, null, "AM", null, null, null).size());

		// filter date
		Assert.assertEquals(1, auctionService.find(null, null, null, null, null, date("01-01-2015 00:00"), null).size());
		log.debug(auctionService.find(null, null, null, null, null, date("01-01-2015 00:00"), null));
		
		// filter date
		Assert.assertEquals(1, auctionService.find(null, null, null, null, null, null, date("01-12-2013 00:00")).size());
		log.debug(auctionService.find(null, null, null, null, null, null, date("01-12-2013 00:00")));
		
		// filter date
		Assert.assertEquals(4, auctionService.find(null, null, null, null, null, date("01-01-2010 00:00"), date("01-01-2014 00:00")).size());
		log.debug(auctionService.find(null, null, null, null, null, date("01-01-2010 00:00"), date("01-01-2014 00:00")));
	}

	Date date(String dateString) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		try {
			return sdf.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}
}
