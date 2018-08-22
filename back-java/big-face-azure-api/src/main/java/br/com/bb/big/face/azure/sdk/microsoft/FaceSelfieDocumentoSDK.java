package br.com.bb.big.face.azure.sdk.microsoft;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import br.com.bb.big.library.exception.VelmaException;
import br.com.bb.big.library.microsoft.enums.DadosMicrosoftEnum;

/**
 * Classe que conecta na API da Microsoft
 * @author c1297467
 *
 */
public final class FaceSelfieDocumentoSDK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6802769443733738354L;

	/**
	 * Método que contém a instância da classe
	 * @return
	 */
	public static FaceSelfieDocumentoSDK getInstancia() {
		return new FaceSelfieDocumentoSDK();
	}
	
	/**
	 * Método que faz a detecção de face pela selfie e pelo documento
	 * @return
	 * @throws URISyntaxException 
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public HttpEntity faceDetection(String body) throws VelmaException, URISyntaxException, ClientProtocolException, IOException {
		HttpClient httpclient = new DefaultHttpClient();

        URIBuilder builder = new URIBuilder(DadosMicrosoftEnum.URL_API_MICROSOFT_FACE_SIMILARY.getMessage());

        // Request parameters. All of them are optional.
        builder.setParameter("returnFaceId", "true");
        builder.setParameter("returnFaceLandmarks", "false");
        builder.setParameter("returnFaceAttributes", DadosMicrosoftEnum.DATA_ATRIBUTES_MICROSOFT_FACE_DETECT.getMessage());

        // Prepare the URI for the REST API call.
        URI uri = builder.build();
        HttpPost request = new HttpPost(uri);

        // Request headers.
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Ocp-Apim-Subscription-Key", DadosMicrosoftEnum.KEY_MICROSOFT.getMessage());

        // Request body.
        StringEntity reqEntity = new StringEntity(body);
        request.setEntity(reqEntity);

        // Execute the REST API call and get the response entity.
        HttpResponse response = httpclient.execute(request);

        return response.getEntity();
	}
	
}