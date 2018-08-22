package br.com.bb.face.azure.bo;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;

import br.com.bb.big.face.azure.sdk.microsoft.FaceAddImageSDK;
import br.com.bb.big.face.azure.sdk.microsoft.FaceSelfieDocumentoSDK;
import br.com.bb.big.face.azure.util.CreateBodySimilaryUtil;
import br.com.bb.big.library.exception.VelmaException;

/**
 * Classe negocial para face recognition
 * @author paulocotta
 *
 */
public class FaceRecognitionBO {

	public HttpEntity validaSelfieDocumentoPessoal(String selfie, String documento, String sufixoSelfie, String sufixoDocumento) 
			throws ClientProtocolException, VelmaException, URISyntaxException, IOException {
		
		String keySelfie = FaceAddImageSDK.getInstacia().faceDetection(CreateBodySimilaryUtil.getInstancia().createBody(selfie, sufixoSelfie));
		FaceAddImageSDK.getInstacia().faceDetection(CreateBodySimilaryUtil.getInstancia().createBody(documento, sufixoDocumento));
		
		return FaceSelfieDocumentoSDK.getInstancia().faceDetection(CreateBodySimilaryUtil.getInstancia().createBodySimilary(keySelfie).toString());
	}
	
}