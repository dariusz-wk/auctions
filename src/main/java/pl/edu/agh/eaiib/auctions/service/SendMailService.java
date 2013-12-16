package pl.edu.agh.eaiib.auctions.service;

public interface SendMailService {
	void sendMail(String from, String to, String message);
}
