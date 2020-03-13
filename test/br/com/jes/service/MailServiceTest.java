package br.com.jes.service;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.junit.jupiter.api.Test;

import br.com.jes.model.ContaEmail;
import br.com.jes.model.Email;

class MailServiceTest {

	private String titulo = "Email de Teste";
	private String conteudo = "Testando email!";
	private String enderecos = "paulo.ferreira@hst.ogr.br, phgferreira@outlook.com";
	
	// Dados para definição da conta
	private String servidor = "smtp.office365.com";
	private String porta = "587";
	private String endereco = "intranet@hst.org.br";
	private String usuario = "intranet@hst.org.br";
	private String senha = "#st477*rj";

	@Test
	public void sendEmailTest() {
		Email email = new Email(titulo, enderecos, conteudo);
		ContaEmail conta = new ContaEmail(servidor, porta, endereco, usuario, senha);
		
		try {
			new MailService().send(conta, email);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
