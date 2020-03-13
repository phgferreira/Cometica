package br.com.jes.view;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import br.com.jes.control.DenunciaEticaController;
import br.com.jes.model.DenunciaEtica;
import br.com.jes.model.Denunciado;
import br.com.jes.model.Denunciante;
import br.com.jes.model.Instituicao;

@ManagedBean
@SessionScoped
public class DenunciaEticaBean {

	private DenunciaEtica denuncia;
	
	@PostConstruct
	public void init() {
		// Inicializa as classes necessárias
		denuncia = new DenunciaEtica();
		denuncia.setInstituicao(new Instituicao());
		denuncia.getInstituicao().setNome("Hospital Santa Teresa");
		denuncia.getInstituicao().setEndereco("Rua Paulino Afonso, Nº 477");
		denuncia.getInstituicao().setBairro("Bingen");
		denuncia.getInstituicao().setCidade("Petrópolis");
		denuncia.getInstituicao().setCep("25684-900");
		denuncia.getInstituicao().setTelefone("(24) 2233 - 4600");
		denuncia.setDenunciante(new Denunciante());
		denuncia.setDenunciado(new Denunciado());
	}
	
	private void redirect(String url) {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		try {
			context.redirect(context.getRequestContextPath()+url);
		} catch (IOException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
		}
	}
	
	public void comeBack() {
		init();
		redirect("/index.jsf");
	}
	
	public void sendEmail() {
		try {
			// Envia denúncia por e-mail
			new DenunciaEticaController().sendEmail(denuncia);
			// Redireciona para página de impressão
			//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "E-Mail enviado"));
			redirect("/denuncia_etica_form.jsf");
		} catch (AddressException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
		} catch (IllegalArgumentException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
		} catch (IllegalAccessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
		} catch (InvocationTargetException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
		} catch (NoSuchMethodException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
		} catch (SecurityException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
		} catch (IOException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
		} catch (MessagingException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
		}
	}

	public DenunciaEtica getDenuncia() {
		return denuncia;
	}

	public void setDenuncia(DenunciaEtica denuncia) {
		this.denuncia = denuncia;
	}

}
