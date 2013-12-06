package pl.edu.agh.eaiib.auctions.model;

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
@Table(name = "IMAGE")
public class Image extends BaseBean<Long> {
	@Id
	@GeneratedValue
	@Column(name = "IMG_ID")
	private Long id;

	@Column(name = "URL")
	private String url;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AUCTION_ID", nullable = false)
	private Auction auction;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Auction getAuction() {
		return auction;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}
}
