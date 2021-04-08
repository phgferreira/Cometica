package br.com.jes.control;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import br.com.jes.model.ContaEmail;
import br.com.jes.model.DenunciaEtica;
import br.com.jes.model.Email;
import br.com.jes.service.FormService;
import br.com.jes.service.MailService;

public class DenunciaEticaController {
	
	// Dados para contrução do email
	private String pathFile = "http://10.7.0.15/intranet/default_forms/form_denuncia_etica.html";
	private String tituloEmail = "Comissão de Ética - Denúncia";
	//private String enderecos = "juliana.santos@hst.org.br, iris.lima@hst.org.br";
	/* Modificado dia 08/04/2021 pelo Paulo Ferreira  - chamado C2104/2987 */
	private String enderecos = "comissaoeticaenfermagem@hst.org.br";
	
	// Dados para definição da conta
	private String servidor = "smtp.office365.com";
	private String porta = "587";
	private String endereco = "intranet@hst.org.br";
	private String usuario = "intranet@hst.org.br";
	private String senha = "#st477*rj";

	private FormService fs = new FormService();

	public void sendEmail(DenunciaEtica denuncia) throws IOException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException, AddressException, MessagingException {
		// Carrega arquivo de escopo para envio do e-mail
		String conteudo = fs.loadFile(pathFile);
		// Substitui os marcadores dentro do arquivo por valores reais
		conteudo = fs.replaceParameters(conteudo, denuncia.getValuesInParameterForm());

		// Cria o email
		Email email = new Email(tituloEmail, enderecos, conteudo);
		
		// Define conta de email que será utilizada para o envio
		ContaEmail conta = new ContaEmail(servidor, porta, endereco, usuario, senha);
		
		// Envia o email
		new MailService().send(conta, email);
	}
	
}
