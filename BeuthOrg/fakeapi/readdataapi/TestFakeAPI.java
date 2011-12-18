package readdataapi;


/**
 * @author Claudia Schaefer
 *
 */
public class TestFakeAPI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(ReadData.LogIn("770041", "1234").toString());
		System.out.println(ReadData.getAllEvents().toString());
		System.out.println(ReadData.getAllLehrkraftnews().toString());
		System.out.println(ReadData.getProfDataByProfname("Grude").toString());
		System.out.println(ReadData.getModulDescriptionByStudOrd("1", "MME1").toString());
		System.out.println(ReadData.getStudienDoku().toString());
		
	}

}
