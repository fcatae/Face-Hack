package br.com.bb.big.face.azure.dto;

/**
 * Classe para executar a similaridade
 * @author paulocotta
 *
 */
public class SimilaryDto {

	private String selfie;
	
	private String sufixoSelfie;
	
	private String documento;
	
	private String sufixoDocumento;

	public String getSelfie() {
		return selfie;
	}

	public void setSelfie(String selfie) {
		this.selfie = selfie;
	}

	public String getSufixoSelfie() {
		return sufixoSelfie;
	}

	public void setSufixoSelfie(String sufixoSelfie) {
		this.sufixoSelfie = sufixoSelfie;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getSufixoDocumento() {
		return sufixoDocumento;
	}

	public void setSufixoDocumento(String sufixoDocumento) {
		this.sufixoDocumento = sufixoDocumento;
	}
	
}