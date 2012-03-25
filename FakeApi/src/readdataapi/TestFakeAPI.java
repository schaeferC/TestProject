package readdataapi;


/**
 * Testklasse zum Ausführen der ReadData-Klasse
 * @author Claudia Schaefer
 *
 */
public class TestFakeAPI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(ReadData.LogIn("000041", "1234").toString());
		System.out.println(ReadData.getAllEvents().toString());
		System.out.println(ReadData.getAllLehrkraftnews().toString());
		System.out.println(ReadData.getProfDataByProfname("Ripphausen-Lipa").toString());
		System.out.println(ReadData.getModulDescriptionByStudOrd("1", "ALG").toString());
		System.out.println(ReadData.getStudienDoku().toString());
		
		
		
	}

}
