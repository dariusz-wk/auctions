package pl.edu.agh.eaiib.auctions.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import pl.edu.agh.eaiib.auctions.core.model.BaseBean;

@Entity
@Table(name = "AUCTION")
public class Auction extends BaseBean<Long> {

	@Id
	@GeneratedValue
	@Column(name = "AUCTION_ID")
	protected Long id;

	@Column(name = "AUCTION_TITLE")
	protected String auctionTitle;

	@Column(name = "AUCTION_START")
	protected Date auctionStart;

	@Column(name = "AUCTION_END")
	protected Date auctionEnd;

	@Column(name = "AUCTION_START_PRICE")
	protected double auctionStartPrice;

	@Column(name = "AUCTION_CURRENT_PRICE")
	protected double auctionCurrentPrice;

	@Column(name = "AUCTION_DESC")
	protected String auctionDescription;

	@Column(name = "AUCTION_DELIVERY_DESC")
	protected String auctionDeliveryDesc;

	@Column(name = "AUCTION_FINISHED")
	protected Boolean finished;

	@Column(name = "AUCTION_WON")
	protected Boolean won;

	@Column(name = "AUCTION_FINALIZED")
	protected Boolean finalized;

	@Column(name = "AUCTION_OWNER")
	protected String amLogin;

	@OneToMany(mappedBy = "auction", orphanRemoval = true)
	@Cascade(value={org.hibernate.annotations.CascadeType.ALL})
	private List<Image> auctionImgUrl;

	@OneToOne(mappedBy = "auction", optional = true, orphanRemoval = true)
	@Cascade(value={org.hibernate.annotations.CascadeType.ALL})
	protected AMContact auctionManagerContact;

	@OneToOne(mappedBy = "auction", optional = true, orphanRemoval = true)
	@Cascade(value={org.hibernate.annotations.CascadeType.ALL})
	protected BuyerContact buyerContact;

	@OneToMany(mappedBy = "auction", orphanRemoval = true)
	@Cascade(value={org.hibernate.annotations.CascadeType.ALL})
	protected List<Bet> betList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuctionTitle() {
		return auctionTitle;
	}

	public void setAuctionTitle(String auctionTitle) {
		this.auctionTitle = auctionTitle;
	}

	public Date getAuctionStart() {
		return auctionStart;
	}

	public void setAuctionStart(Date auctionStart) {
		this.auctionStart = auctionStart;
	}

	public Date getAuctionEnd() {
		return auctionEnd;
	}

	public void setAuctionEnd(Date auctionEnd) {
		this.auctionEnd = auctionEnd;
	}

	public double getAuctionStartPrice() {
		return auctionStartPrice;
	}

	public void setAuctionStartPrice(double auctionStartPrice) {
		this.auctionStartPrice = auctionStartPrice;
	}

	public double getAuctionCurrentPrice() {
		return auctionCurrentPrice;
	}

	public void setAuctionCurrentPrice(double auctionCurrentPrice) {
		this.auctionCurrentPrice = auctionCurrentPrice;
	}

	public String getAuctionDescription() {
		return auctionDescription;
	}

	public void setAuctionDescription(String auctionDescription) {
		this.auctionDescription = auctionDescription;
	}

	public String getAuctionDeliveryDesc() {
		return auctionDeliveryDesc;
	}

	public void setAuctionDeliveryDesc(String auctionDeliveryDesc) {
		this.auctionDeliveryDesc = auctionDeliveryDesc;
	}

	public Boolean getFinished() {
		return finished;
	}

	public void setFinished(Boolean finished) {
		this.finished = finished;
	}

	public Boolean getWon() {
		return won;
	}

	public void setWon(Boolean won) {
		this.won = won;
	}

	public Boolean getFinalized() {
		return finalized;
	}

	public void setFinalized(Boolean finalized) {
		this.finalized = finalized;
	}

	public String getAmLogin() {
		return amLogin;
	}

	public void setAmLogin(String amLogin) {
		this.amLogin = amLogin;
	}

	public List<Bet> getBetList() {
		if(betList == null){
			betList =  new ArrayList<Bet>();
		}
		return betList;
	}
	public void addBet(Bet bet) {
		getBetList().add(bet);
		bet.setAuction(this);
	}

	public void setBetList(List<Bet> betList) {
		this.betList = betList;
	}

	public AMContact getAuctionManagerContact() {
		return auctionManagerContact;
	}

	public void setAuctionManagerContact(AMContact auctionManagerContact) {
		this.auctionManagerContact = auctionManagerContact;
		auctionManagerContact.setAuction(this);
	}

	public BuyerContact getBuyerContact() {
		return buyerContact;
	}

	public void setBuyerContact(BuyerContact buyerContact) {
		this.buyerContact = buyerContact;
		 buyerContact.setAuction(this);
	}

	public List<Image> getAuctionImgUrl() {
		if(this.auctionImgUrl == null){
			this.auctionImgUrl =  new ArrayList<Image>();
		}
		return auctionImgUrl;
	}

	public void addAuctionImgUrl(Image auctionImgUrl) {
		getAuctionImgUrl().add(auctionImgUrl);
		auctionImgUrl.setAuction(this);
	}

	public void setAuctionImgUrl(List<Image> auctionImgUrl) {
		this.auctionImgUrl = auctionImgUrl;
	}

}
