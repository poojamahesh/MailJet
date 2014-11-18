package com.myMail;
 
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.awt.Color;
public class myMail
{
	public static void main (String [] args)
	{
		
		final String APIKey = "a8956362d198192ca9d352a694dfd11d";
		final String SecretKey = "d7e86fb37bd15ca2303adff47dd894a1";
		String From = "pooja11mahesh@gmail.com";
		
		String To = "geekmlle@gmail.com";
		String takebackMail = "geekmlle@gmail.com";
        String WRAPmail = "geekmlle@gmail.com";
		Properties props = new Properties ();
 
		props.put ("mail.smtp.host", "in.mailjet.com");
		props.put ("mail.smtp.socketFactory.port", "465");
		props.put ("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put ("mail.smtp.auth", "true");
		props.put ("mail.smtp.port", "465");
 
		Session session = Session.getDefaultInstance (props,
			new javax.mail.Authenticator ()
			{
				protected PasswordAuthentication getPasswordAuthentication ()
				{
					return new PasswordAuthentication (APIKey, SecretKey);
				}
			});
 
		try
		{
			
			 Message message = new MimeMessage (session);
			message.setFrom (new InternetAddress (From));
			message.setRecipients (Message.RecipientType.TO, InternetAddress.parse(To));
			message.setSubject ("IntelliBINS");
			message.setContent("<b><font color=\"blue\">Good job! Recycling a single aluminium can saves enough energy to power your television for three hours or to run a 100-watt light bulb for almost four hours.</font></b>","text/html");
		    message.setRecipients (Message.RecipientType.TO, InternetAddress.parse(takebackMail));
			message.setSubject ("IntelliBINS");
			message.setContent("<b><font color=\"green\">NYC Take-Back Program: <br><br>Make sure you are not trashing that plastic bag - take it back to the store! Did you know that some retailers and service providers are required by law to take back certain products at the point of disposal? Under NYC Recycle’s Take-It-Back program, retailers and vendors are also charged with reducing their commercial footprint in NYC. Here is a non-exhaustive list of some of the types of items you can return at the end of their shelf life and the corresponding retails or service providers where you can take them:<br><br>Plastic Bags: Pharmacies, Drug Stores, Consumer Electronic Stores, Office Supply Stores, Groceries, Delis, Hardware Stores, Auto Part Retailers<br><br>Rechargeable Batteries: Pharmacies, Drug Stores, Consumer Electronic Stores, Office Supply Stores, Hardware StoresMedical Sharps: Pharmacies, Drug Stores, Hospitals, Nursing homes</font></b>","text/html");
			message.setSubject ("IntelliBINS");
			message.setContent("<b><font color=\"purple\">Wrap Recycling Action Program:<br><br> And don’t just recycle your plastic bag, recycle any plastic film packaged with your goods. There are many retailers right here in NYC serving as drop-off locations for this purpose. Some example retailers include Target, JC Penney, and Trader Joes.<br><br>For more information see: plasticfilmrecycling.org/</font></b>","text/html");

			Transport.send (message);
 
		}
		catch (MessagingException e)
		{
			throw new RuntimeException (e);
		}
	}
}