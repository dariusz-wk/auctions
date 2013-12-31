package pl.edu.agh.eaiib.auctions.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.edu.agh.eaiib.auctions.service.SendMailService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-config.xml" })
public class SendMailServiceTest {
    @Autowired
    SendMailService sendMailService;

    @Test
    public void sendSampleMail() {
        // disable demo mode first is test spring config and set smtp
        sendMailService.sendMail("no-reply", "", "TESTING MESSAGE SENDER");
    }
}
