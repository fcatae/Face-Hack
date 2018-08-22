package br.com.bb.face.azure.controller;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.bb.big.face.azure.dto.SimilaryDto;
import br.com.bb.big.library.exception.VelmaException;
import br.com.bb.face.azure.bo.FaceRecognitionBO;

/**
 * Classe de similaridade de faces
 * @author paulocotta
 *
 */

@Controller
@RequestMapping("/face-microsoft-selfie")
public class FaceRecognitionController {

	@Autowired
	private FaceRecognitionBO faceRecognitionBO;
	
	@RequestMapping(value = "/selfie", method = RequestMethod.POST)
	public ResponseEntity<HttpEntity> validaSelfieDocumentoPessoal(SimilaryDto similaryDto) throws ClientProtocolException, VelmaException, URISyntaxException, IOException {
		return ResponseEntity.ok(faceRecognitionBO.validaSelfieDocumentoPessoal(similaryDto.getSelfie(), similaryDto.getDocumento(), 
				similaryDto.getSufixoSelfie(), similaryDto.getSufixoDocumento()));
	}
	
}