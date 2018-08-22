package br.com.bb.big.library.microsoft.enums;

/**
 * Classe com os dados da microsoft
 * @author c1297467
 *
 */
public enum DadosMicrosoftEnum {

	KEY_MICROSOFT("429f7958a1a94dd492ce24d7ea31d7e8"),//key do banco("d573e45d90f145739a5b52f361e6960c"),
	URL_API_MICROSOFT_FACE_DETECT("https://brazilsouth.api.cognitive.microsoft.com/face/v1.0/detect"),
	URL_API_MICROSOFT_FACE_SIMILARY("https://brazilsouth.api.cognitive.microsoft.com/face/v1.0/findsimilars"),
	URL_API_MICROSOFT_FACE_LIST_ADD("https://brazilsouth.api.cognitive.microsoft.com/face/v1.0/facelists"),
	URL_API_MICROSOFT_FACE_GROUP("https://brazilsouth.api.cognitive.microsoft.com/face/v1.0/findsimilars"),
	DATA_ATRIBUTES_MICROSOFT_FACE_DETECT("age,gender,headPose,smile,facialHair,glasses,emotion,hair,makeup,occlusion,accessories,blur,exposure,noise");

    private String message;

    private DadosMicrosoftEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
	
}