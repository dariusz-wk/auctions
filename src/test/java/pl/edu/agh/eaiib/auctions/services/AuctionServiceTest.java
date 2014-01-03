package pl.edu.agh.eaiib.auctions.services;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.edu.agh.eaiib.auctions.service.AuctionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-config.xml", "/task-test-config.xml" })
public class AuctionServiceTest {
    @Autowired
    AuctionService auctionService;

    @Test
    public void test1() {
        Assert.assertNotNull(auctionService);
        Assert.assertEquals(1, auctionService.find("ROLMEX", null, null, null, null, null, null).size());

        Assert.assertEquals(5, auctionService.find(null, null, null, null, null, null, null).size());

        Assert.assertEquals(1, auctionService.find(null, true, null, null, null, null, null).size());

        Assert.assertEquals(1, auctionService.find(null, true, null, null, null, null, null).size());
    }

    Date date(String dateString) {
        // SimpleDateFormat sdf = new SimpleDateFormat(")
        return null;
    }
}
