package readdataapi;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import util.Constants;

/**
 * Diese Klasse dient als API-Schnittstelle für die Fakedaten
 * @author Claudia Schaefer
 *
 */
public class ReadData {

	private static String matrikelnr;

	/**
	 * Liest die Datei filePath aus.
	 * @param filePath
	 * 		String, Datei die ausgelesen wird
	 * @return
	 */
	public static JSONObject lies(String filePath) {

		try {
			FileReader fr = new FileReader(filePath);

			BufferedReader br = new BufferedReader(fr);
			JSONObject json = new JSONObject(br.readLine());

			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Überprüft ob ein Student mit matrikelnr und pw registriert ist. Wenn ja werden die Daten des Studenten zurückgegeben. Ansonsten ein ErrorCode.
	 * @param matrikelnr
	 * 		String, Matrikelnummer des Studenten
	 * @param pw
	 * 		String, Passwort mit dem Student registriert ist
	 * @return
	 */
	public static JSONObject LogIn(String matrikelnr, String pw) {
		File file = new File(Constants.PATH + "/" + Constants.REGISTRATION_DATA + ""
				+ Constants.JSON2);
		JSONObject json = lies(file.getAbsolutePath());
		try {
			JSONArray jsonArray = json.getJSONArray("Registration");
			for (int i = 0; i < jsonArray.length(); i++) {
				if (jsonArray.getJSONObject(i)
						.getString("RegistrationMatrikelnr").equals(matrikelnr)
						&& jsonArray.getJSONObject(i)
								.getString("RegistrationPassword").equals(pw)) {
					File getStudent = new File(Constants.PATH
							+ Constants.STUDENT_DATA + "/" + matrikelnr + ""
							+ Constants.JSON2);
					if (getStudent.exists()) {
						setMatrikelnr(matrikelnr);
						return lies(getStudent.getAbsolutePath());
					}
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		JSONObject erg = null;
		try {
			erg = new JSONObject("{\"ErrorCode\":\"NotExist\",\"Student\":{}}");
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return erg;

	}

	/**
	 * Methode ist veraltet und wird nicht mehr benötigt.
	 * @return
	 */
	public static JSONObject getAllLehrkraftnews() {
		File[] files = new File(Constants.PATH + Constants.LEHRKRAFTNEWS_DATA + "/")
				.listFiles();
		JSONObject jsonObject = new JSONObject();
		String jsonSource = new String();

		jsonSource = jsonSource
				.concat("{\"ErrorCode\":\"\",\"Lehrkraftnews\":[");

		if (files.length == 0) {
			try {
				jsonObject = new JSONObject(
						"{\"ErrorCode\":\"NotExist\",\"Lehrkraftnews\":[]}");
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return jsonObject;
		}
		for (int i = 0; i < files.length; i++) {
			if (i + 1 < files.length) {
				jsonSource = jsonSource.concat(lies(files[i].getAbsolutePath())
						.toString() + ",");
				continue;
			}
			jsonSource = jsonSource.concat(lies(files[i].getAbsolutePath())
					.toString() + "]}");
			try {
				jsonObject = new JSONObject(jsonSource);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return jsonObject;

	}

	/**
	 * Gibt alle bevorstehenden Events zurück
	 * @return
	 */
	public static JSONObject getAllEvents() {
		File[] files = new File(Constants.PATH + Constants.Event_DATA + "/")
				.listFiles();
		JSONObject jsonObject = new JSONObject();
		String jsonSource = new String();

		jsonSource = jsonSource.concat("{\"ErrorCode\":\"\",\"Events\":[");

		if (files.length == 0) {
			try {
				jsonObject = new JSONObject(
						"{\"ErrorCode\":\"NotExist\",\"Events\":[]}");
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return jsonObject;
		}
		for (int i = 0; i < files.length; i++) {
			if (i + 1 < files.length) {
				jsonSource = jsonSource.concat(lies(files[i].getAbsolutePath())
						.toString() + ",");
				continue;
			}
			jsonSource = jsonSource.concat(lies(files[i].getAbsolutePath())
					.toString() + "]}");
			try {
				jsonObject = new JSONObject(jsonSource);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return jsonObject;

	}

	/**
	 * Gibt alle vorhandenen Daten eines Profs mit profname zurück
	 * @param profname
	 * 		String, Prof von dem die Daten zurückgegeben werden sollen.
	 * @return
	 */
	public static JSONObject getProfDataByProfname(String profname) {
		File file = new File(Constants.PATH + Constants.PROF_DATA + "/" + profname
				+ "" + Constants.JSON2);
		if (!file.exists()) {
			try {
				return new JSONObject(
						"{\"ErrorCode\":\"NoInformationExist\",\"ProfData\":{}}");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		JSONObject json = lies(file.getAbsolutePath());
		String source = new String("{\"ErrorCode\":\"\",\"ProfData\":"
				+ json.toString() + "}");
		try {
			json = new JSONObject(source);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return json;

	}

	/**
	 * Gibt die Modulbeschreibung eines Moduls nach der Studienordnung nach der ein Student studiert zurück.
	 * @param studord
	 * 		String, Studienordnung des Studenten
	 * @param modulname
	 * 		String, Name des Moduls dessen Beschreibung zurückgegeben werden soll
	 * @return
	 */
	public static JSONObject getModulDescriptionByStudOrd(String studord,
			String modulname) {
		File file = new File(Constants.PATH + "" + studord + "" + Constants.JSON2);
		if (!file.exists()) {
			try {
				return new JSONObject(
						"{\"ErrorCode\":\"NoModulDescription\",\"ModulOrd\":{}}");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		JSONObject json = lies(file.getAbsolutePath());
		JSONArray jsonArray = null;
		try {
			jsonArray = json.getJSONArray("ModulOrd");
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int i = 0; i < jsonArray.length(); i++) {
			try {
				if (jsonArray.getJSONObject(i).getString("ModulNameOrd")
						.equals(modulname)) {
					String source = new String(
							"{\"ErrorCode\":\"\",\"ModulOrd\":"
									+ jsonArray.getJSONObject(i).toString()
									+ "}");
					try {
						json = new JSONObject(source);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					return json;

				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		try {
			json = new JSONObject(
					"{\"ErrorCode\":\"NoModulDescription\",\"ModulOrd\":{}}");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * Gibt die Studienordnung eines Studenten zurück.
	 * @return
	 */
	public static JSONObject getStudienDoku() {
		File file = new File(Constants.PATH + Constants.STUDIENDOKU_DATA + "/Doku"
				+ getMatrikelnr() + "" + Constants.JSON2);
		JSONObject json = new JSONObject();
		if (file.exists()) {
			String source = new String("{\"ErrorCode\":\"\",");
			String source2 = lies(file.getAbsolutePath()).toString();
			source = source.concat(source2.substring(1));
			try {
				json = new JSONObject(source);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return json;

		}
		String source = new String(
				"{\"ErrorCode\":\"NotStudiendokuExist\",\"Studiendoku\":[]}");
		try {
			json = new JSONObject(source);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * Getter
	 * @return
	 */
	public static String getMatrikelnr() {
		return matrikelnr;
	}

	/**
	 * Setter
	 * @param matrikelnr
	 */
	public static void setMatrikelnr(String matrikelnr) {
		ReadData.matrikelnr = matrikelnr;
	}

}
