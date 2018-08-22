package br.com.bb.big.face.azure.sdk.microsoft;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import br.com.bb.big.library.exception.VelmaException;
import br.com.bb.big.library.microsoft.enums.DadosMicrosoftEnum;

/**
 * Classe responsável por adicionar a imagem
 * @author paulocotta
 *
 */
public class FaceAddImageSDK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2098056348474280891L;
	
	/**
	 * Método que image sdk instância
	 * @return
	 */
	public static FaceAddImageSDK getInstacia(){
		return new FaceAddImageSDK();
	}

	/**
	 * Método que adiciona imagens
	 * @return
	 * @throws URISyntaxException 
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public String faceDetection(FileEntity body) throws VelmaException, URISyntaxException, ClientProtocolException, IOException {
		HttpClient httpclient = new DefaultHttpClient();

        URIBuilder builder = new URIBuilder(DadosMicrosoftEnum.URL_API_MICROSOFT_FACE_LIST_ADD.getMessage());

        // Request parameters. All of them are optional.
        builder.setParameter("returnFaceId", "true");

        // Prepare the URI for the REST API call.
        URI uri = builder.build();
        HttpPost request = new HttpPost(uri);

        // Request headers.
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Ocp-Apim-Subscription-Key", DadosMicrosoftEnum.KEY_MICROSOFT.getMessage());

        // Request body.
        request.setEntity(body);

        // Execute the REST API call and get the response entity.
        HttpResponse response = httpclient.execute(request);

        return response.getEntity().toString();
	}
	
}