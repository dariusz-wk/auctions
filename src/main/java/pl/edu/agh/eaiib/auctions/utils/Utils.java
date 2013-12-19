package pl.edu.agh.eaiib.auctions.utils;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class Utils extends org.apache.commons.lang.StringUtils {
	public static double parseDouble(String value) {
		if (isNotBlank(value)) {
			try {
				return Double.parseDouble(value);
			} catch (NumberFormatException e) {

			}
		}
		return 0.0;
	}

	public static Long parseLong(String value) {
		if (isNotBlank(value)) {
			try {
				return Long.parseLong(value);
			} catch (NumberFormatException e) {

			}
		}
		return null;
	}

	public static Date formatDate(XMLGregorianCalendar auctionEnd) {
		if (null == auctionEnd) {
			return null;
		}
		return auctionEnd.toGregorianCalendar().getTime();
	}

	public static String formatCurrency(double auctionCurrentPrice) {
		String currentcy = Double.toString(auctionCurrentPrice);

		return currentcy;
	}

	public static XMLGregorianCalendar formatGeorgianCalendar(Date betTime) {
		if (betTime == null) {
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

	private static String CURRENCY_REGEXP = "^[0-9]+(\\.[0-9]{2})?$";

	public static boolean isCurrency(String text) {
		return text.matches(CURRENCY_REGEXP);
	}

	private static String LOGIN_REGEXP = "^[a-zA-Z][a-zA-Z0-9]{4,99}$";

	public static boolean isLogin(String text) {
		return text.matches(LOGIN_REGEXP);
	}

	private static String BANK_ACCOUNT_REGEXP = "^[0-9]{2}[ ]?([0-9]{4}[ ]?){6}$";

	public static boolean isBankAccount(String text) {
		return text.matches(BANK_ACCOUNT_REGEXP);
	}

	private static String EMAIL_REGEXP = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";

	public static boolean isEmail(String text) {
		return text.matches(EMAIL_REGEXP);
	}

	private static String PHONE_REGEXP = "^([+][0-9]{2}[ ])?([0-9]{3}[ ]?){3}$";

	public static boolean isPhone(String text) {
		return text.matches(PHONE_REGEXP);
	}

	public static boolean isBlank(String t) {
		if (t.length() > 254)
			return false;
		return org.apache.commons.lang.StringUtils.isBlank(t);
	}

}
