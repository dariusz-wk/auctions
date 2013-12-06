package pl.edu.agh.eaiib.auctions.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import pl.edu.agh.eaiib.auctions.core.model.BaseBean;

@Entity
@Table(name="CONTACT")
public class Contact extends BaseBean<Long> {
	@Id
	@GeneratedValue
	@Column(name = "CONTACT_ID")
	private Long id;
	
	@Column(name = "LOGIN")
	private String login;

	@Column(length = 16, name = "BANK_ACCOUNT_NB")
	private String bankAccountNb;

	@Column(name = "BANK")
	private String bank;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SURNAME")
	private String surname;

	@Column(name = "ADDRESS")
	private String address;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Auction buyerAuction;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Auction amAuction;
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getBankAccountNb() {
		return bankAccountNb;
	}

	public void setBankAccountNb(String bankAccountNb) {
		this.bankAccountNb = bankAccountNb;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Auction getBuyerAuction() {
		return buyerAuction;
	}

	public void setBuyerAuction(Auction buyerAuction) {
		this.buyerAuction = buyerAuction;
	}

	public Auction getAmAuction() {
		return amAuction;
	}

	public void setAmAuction(Auction amAuction) {
		this.amAuction = amAuction;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


}
