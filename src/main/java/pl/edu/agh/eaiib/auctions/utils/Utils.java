package pl.edu.agh.eaiib.auctions.utils;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class Utils extends org.apache.commons.lang.StringUtils {
	public static double parseDouble(String value){
		if(isNotBlank(value)){
			try{
				return Double.parseDouble(value);
			} catch (NumberFormatException e){
				
			}
		}
		return 0.0;		
	}
	public static Long parseLong(String value){
		if(isNotBlank(value)){
			try{
				return Long.parseLong(value);
			} catch (NumberFormatException e){
				
			}
		}
		return null;		
	}

	public static Date formatDate(XMLGregorianCalendar auctionEnd) {
		if(null == auctionEnd){
			return null;
		}
		return auctionEnd.toGregorianCalendar().getTime();
	}

	public static String formatCurrency(double auctionCurrentPrice) {
		String currentcy = Double.toString(auctionCurrentPrice);
		
		return currentcy;
	}

	public static XMLGregorianCalendar formatGeorgianCalendar(Date betTime) {
		if(betTime==null){
			return null;
		}
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(betTime);
		XMLGregorianCalendar date2;
		try {
			date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			return date2;
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
			return null;
		}
	}
}
