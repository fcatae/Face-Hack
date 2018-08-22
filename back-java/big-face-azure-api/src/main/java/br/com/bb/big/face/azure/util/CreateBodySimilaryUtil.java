package br.com.bb.big.face.azure.util;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import org.apache.http.entity.FileEntity;

/**
 * Classe responsável para criar o body da similaridade entre as fotos
 * @author c1297467
 *
 */
public class CreateBodySimilaryUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4988380217434676130L;
	
	/**
	 * Instância da classe
	 * @return
	 */
	public static CreateBodySimilaryUtil getInstancia() {
		return new CreateBodySimilaryUtil();
	}

	/**
	 * Método que retorna a imagem
	 * @param imagem
	 * @param sufixo
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	public FileEntity createBody(String imagem, String sufixo) throws IOException{
		File tempFile = File.createTempFile("tmp", sufixo);
        FileEntity reqEntity = new FileEntity(tempFile, "application/octet-stream");
        return reqEntity;
	}
	
	public StringBuffer createBodySimilary(String key){
		StringBuffer body = new StringBuffer();
		body.append("{");
		body.append("'faceId' : '").append(key).append("',");
		body.append("'largeFaceListId' : 'sample_list',");
		body.append("'maxNumOfCandidatesReturned' : ").append(10);
		body.append("'mode' : 'matchPerson'");
		body.append("}");
		
		return body;
	}
	
}