package pl.edu.agh.eaiib.auctions.job;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;

import pl.edu.agh.eaiib.auctions.model.Auction;
import pl.edu.agh.eaiib.auctions.model.Bet;
import pl.edu.agh.eaiib.auctions.service.AuctionService;
import pl.edu.agh.eaiib.auctions.service.SendMailService;

public class FinishAuctionTask {

	private static final Logger log = Logger.getLogger(FinishAuctionTask.class);

	@Autowired
	AuctionService auctionService;

	@Autowired
	SendMailService sendMailService;

	public void run(JobExecutionContext context) {
		log.trace("run");

		List<Auction> finishedAuctions = new ArrayList<Auction>();
		finishedAuctions.addAll(auctionService.findToFinish());

		for (Auction auction : finishedAuctions) {
			if (auction.getBetList().isEmpty()) {
				sendMailService.sendMail("system@auction.pl", auction.getAuctionManagerContact().getEmail(), "Aucton " + auction.getAuctionTitle() + " finished without a win!");

			} else {
				Bet winningBet = auction.getBetList().get(auction.getBetList().size() - 1);
				sendMailService.sendMail("system@auction.pl", auction.getAuctionManagerContact().getEmail(), "Aucton " + auction.getAuctionTitle() + " finished! Client " + winningBet.getCientId() + "is the winner! Wait for more infos");

			}
			auction.setFinished(true);
			auctionService.update(auction);
		}

	}

}
