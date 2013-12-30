package pl.edu.agh.eaiib.auctions.job;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;

import pl.edu.agh.eaiib.auctions.model.Auction;
import pl.edu.agh.eaiib.auctions.model.Bet;
import pl.edu.agh.eaiib.auctions.service.AuctionService;
import pl.edu.agh.eaiib.auctions.service.AuthService;
import pl.edu.agh.eaiib.auctions.service.SendMailService;
import pl.edu.agh.eaiib.auctions.utils.Utils;

public class FinishAuctionTask {

    private static final Logger log = Logger.getLogger(FinishAuctionTask.class);

    @Autowired
    AuctionService auctionService;

    @Autowired
    SendMailService sendMailService;

    @Autowired
    AuthService authService;

    public void run(JobExecutionContext context) {
        log.trace("run");

        List<Auction> finishedAuctions = new ArrayList<Auction>();
        finishedAuctions.addAll(auctionService.findToFinish());

        for (Auction auction : finishedAuctions) {
            String amEmail = authService.getEmail(auction.getAmLogin());
            if ( Utils.isEmail(amEmail) ) {

                if ( auction.getBetList().isEmpty() ) {
                    sendMailService.sendMail("system@auction.pl", amEmail, "Aucton " + auction.getAuctionTitle() + " finished without a win!");

                } else {
                    Bet winningBet = auction.getBetList().get(auction.getBetList().size() - 1);
                    sendMailService.sendMail("system@auction.pl", amEmail,
                            "Aucton " + auction.getAuctionTitle() + " finished! Client " + winningBet.getCientId()
                                    + "is the winner! Check your auction for more client info");

                }
                log.warn("EMAIL SEND AM  " + auction.getAmLogin());
            } else {
                log.warn("EMAIL FOR AM not found " + auction.getAmLogin());
            }

            if ( false == auction.getBetList().isEmpty() ) {
                Bet winningBet = auction.getBetList().get(auction.getBetList().size() - 1);
                String cEmail = authService.getEmail(winningBet.getCientId());
                if ( Utils.isEmail(cEmail) ) {

                    sendMailService.sendMail("system@auction.pl", cEmail, "Hi " + winningBet.getCientId() + "! Aucton " + auction.getAuctionTitle()
                            + " finished! You are the winner! Auction Owner data " + auction.getAuctionManagerContact());
                    log.warn("EMAIL FOR Client send " + winningBet.getCientId());
                } else {
                    log.warn("EMAIL FOR Client not found " + winningBet.getCientId());
                }
            }
            auction.setFinished(true);
            auctionService.update(auction);
        }

    }
}
