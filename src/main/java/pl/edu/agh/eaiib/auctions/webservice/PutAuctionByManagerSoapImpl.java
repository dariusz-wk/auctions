package pl.edu.agh.eaiib.auctions.webservice;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;

import org.apache.log4j.Logger;

import pl.edu.agh.eaiib.auctions.core.webservice.SoapWebService;
import pl.edu.agh.eaiib.auctions.model.AMContact;
import pl.edu.agh.eaiib.auctions.model.Auction;
import pl.edu.agh.eaiib.auctions.utils.Utils;
import pl.edu.agh.eaiib.auctions.wsdl.PutAuctionByManagerSoap;
import pl.edu.agh.eaiib.auctions.xsd.AuctionManagerContactDataType;
import pl.edu.agh.eaiib.auctions.xsd.AuctionType;

@WebService(targetNamespace = "http://eaiib.agh.edu.pl/auctions/wsdl/", name = "PutAuctionByManagerSoap")
@XmlSeeAlso({ pl.edu.agh.eaiib.auctions.xsd.ObjectFactory.class })
public class PutAuctionByManagerSoapImpl extends SoapWebService implements PutAuctionByManagerSoap {

	private static final Logger log = Logger.getLogger(PutAuctionByManagerSoapImpl.class);

	@Override
	public void putAuctionByManager(Holder<AuctionType> auctionHolder, Holder<String> amLoginHolder, AuctionManagerContactDataType auctionManagerContactData, Holder<String> errors) {
		log.trace("putAuctionByManager " + amLoginHolder.value);
		// get references to incoming data
		String amLoginName = amLoginHolder.value;
		AuctionType auction = auctionHolder.value;

		// clear holders for output
		amLoginHolder.value = null;
		auctionHolder.value = null;

		if (!hasMgmtPrivilages(amLoginName)) {
			log.trace("Lack of privileges!");
			errors.value = "Lack of provileges!";
			return;
		}

		String errorMsg = null;
		if (null != (errorMsg = validate(auction, auctionManagerContactData))) {
			log.error("error: " + errorMsg);
			errors.value = "errorMsg";
			return;
		}

		Auction auctionBean = new Auction();
		auctionBean.setAmLogin(amLoginName);
		auctionBean.setAuctionStartPrice(Utils.parseDouble(auction.getAuctionStartPrice()));
		auctionBean.setAuctionDeliveryDesc(auction.getAuctionDeliveryDesc());
		auctionBean.setAuctionEnd(Utils.formatDate(auction.getAuctionEnd()));
		auctionBean.setAuctionStart(Utils.formatDate(auction.getAuctionStart()));
		auctionBean.setAuctionTitle(auction.getAuctionTitle());
		auctionBean.setFinalized(false);
		auctionBean.setWon(false);
		auctionBean.setFinished(false);
		auctionBean.setAuctionDescription(auction.getAuctionDescription());

		AMContact amContact = new AMContact();
		amContact.setAuction(auctionBean);
		amContact.setBank(auctionManagerContactData.getAMAccountBank());
		amContact.setBankAccountNb(auctionManagerContactData.getAMAccountNb());
		amContact.setEmail(auctionManagerContactData.getAMEmail());
		amContact.setLogin(amLoginName);
		amContact.setName(auctionManagerContactData.getAMName());
		amContact.setPhone(auctionManagerContactData.getAMPhone());
		amContact.setSurname(auctionManagerContactData.getAMSurname());

		Long id = auctionService.save(auctionBean);
		if (id == null) {
			errors.value = "Auction creation fail";
			return;
		}

		auctionHolder.value = new AuctionType();
		auctionHolder.value.setAuctionId(id.toString());
		amLoginHolder.value = amLoginName;

		log.debug("OBJECT TO SAVE " + auction.toString());
	}

	private String validate(AuctionType auction, AuctionManagerContactDataType auctionManagerContactData) {
		String errors = "";
		if (auction == null) {
			errors += "Auction cannot be null;\n";
		} else {
			if (Utils.isBlank(auction.getAMLogin())) {
				errors += "AMLogin cannot be null over 254 length;\n";
			} else if (Utils.isLogin(auction.getAMLogin())) {
				errors += "AMLogin invalid format;\n";
			}
			if(Utils.isBlank(auction.getAuctionStartPrice())){
				errors += "AuctionStartPrice cannot be null over 254 length;\n";
			} else if(!Utils.isCurrency(auction.getAuctionStartPrice())){
				errors += "AuctionStartPrice invalid format;\n";
			}

			if(Utils.isBlank(auction.getAuctionDeliveryDesc())){
				errors += "AuctionDeliveryDesc cannot be null over 254 length;\n";
			}

			if(Utils.isBlank(auction.getAuctionTitle())){
				errors += "AuctionTitle cannot be null over 254 length;\n";
			}

			if(Utils.isBlank(auction.getAuctionDescription())){
				errors += "AuctionDescription cannot be null over 254 length;\n";
			}
			if(null == auction.getAuctionEnd()){
				errors += "AuctionEnd cannot be null;\n";
				
			}
			if(null == auction.getAuctionStart()){
				errors += "AuctionStart cannot be null;\n";
				
			}
		}
		if(auctionManagerContactData == null){
			errors += "AuctionManagerContactData cannot be null;\n";
			
		} else {
			if(Utils.isBlank(auctionManagerContactData.getAMAccountBank())){
				errors += "AMAccountBank cannot be null over 254 length;\n";				
			}
			if(Utils.isBlank(auctionManagerContactData.getAMAccountNb())){
				errors += "AMAccountNb cannot be null over 254 length;\n";				
			} else if(!Utils.isBankAccount(auctionManagerContactData.getAMAccountNb())){
				errors += "AMAccountNb invalid back account";
			}

			if(Utils.isBlank(auctionManagerContactData.getAMEmail())){
				errors += "AMEmail cannot be null over 254 length;\n";				
			} else if(!Utils.isEmail(auctionManagerContactData.getAMEmail())){
				errors += "AMEmail invalid email format";
			}

			if(Utils.isBlank(auctionManagerContactData.getAMName())){
				errors += "AMName cannot be null all over 254 length;\n";				
			} 

			if(Utils.isBlank(auctionManagerContactData.getAMName())){
				errors += "AMSurname cannot be null over 254 length;\n";				
			} 

			if(Utils.isBlank(auctionManagerContactData.getAMPhone())){
				errors += "AMPhone cannot be null over 254 length;\n";				
			} else if(!Utils.isPhone(auctionManagerContactData.getAMPhone())){
				errors += "AMPhone invalid email format";
			}
		}
		return Utils.isBlank(errors) ? null : errors;
	}

}
