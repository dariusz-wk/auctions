package pl.edu.agh.eaiib.auctions.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pl.edu.agh.eaiib.auctions.core.model.BaseBean;

@Entity
@Table(name = "BET")
public class Bet extends BaseBean<Long> {

	@Id
	@GeneratedValue
	@Column(name = "BET_ID")
	protected Long id;
	@Column(name = "BET_PRICE")
	protected double betPrice;
	@Column(name = "BET_TIME")
	protected Date betTime;
	@Column(name = "CLIENT_ID")
	protected String cientId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AUCTION_ID", nullable = false)
	private Auction auction;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getBetPrice() {
		return betPrice;
	}

	public void setBetPrice(double betPrice) {
		this.betPrice = betPrice;
	}

	public Date getBetTime() {
		return betTime;
	}

	public void setBetTime(Date betTime) {
		this.betTime = betTime;
	}

	public String getCientId() {
		return cientId;
	}

	public void setCientId(String cientId) {
		this.cientId = cientId;
	}

	public Auction getAuction() {
		return auction;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}
}
