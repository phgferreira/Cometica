package br.com.jes.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.jes.model.ContaEmail;
import br.com.jes.model.Email;

public class MailService {

	public void send(ContaEmail conta, Email email) throws AddressException, MessagingException {
		// Propriedades do envio de e-mail (TLS Protocol)
		Properties props = System.getProperties();
		props.setProperty("mail.smtp.host", conta.getServidor());
		props.setProperty("mail.smtp.port", conta.getPorta());
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.starttls.enable", "true");
//		props.setProperty("mail.smtp.socketFactory", port);
//		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		// Autenticação de e-mail
		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(conta.getUsuario(), conta.getSenha());
			}
		};

		// Consolidação e preparo do e-mail
		Session sessao = Session.getDefaultInstance(props, auth);
		MimeMessage msg = new MimeMessage(sessao);
		msg.setFrom(new InternetAddress(conta.getEndereco()));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getEnderecos()));
		msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse("paulo.ferreira@hst.org.br"));
		msg.setSubject(email.getTitulo());
		msg.setText(email.getConteudo(), "utf-8", "html");
		
		// Envia e-mail
		Transport.send(msg);
	}
}
