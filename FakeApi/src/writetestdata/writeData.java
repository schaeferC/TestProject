package writetestdata;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.json.JSONException;
import org.json.JSONObject;

import util.Common;

/**
 * @author Claudia Schaefer
 *
 */
class writeData {

	public static boolean writeJSON(String name, String fileName,
			JSONObject json) {
		if (name.equals(Common.REGISTRATION)) {
			writeFile(new String(Common.PATH + "" + fileName + ""
					+ Common.JSON2), json);

		} else if (name.equals(Common.STUDENT)) {
			createFile(Common.PATH + "" + Common.STUDENT_DATA + "/" + fileName
					+ "" + Common.JSON2, json);

		} else if (name.equals(Common.MODUL)) {
			createFile(Common.PATH + "" + Common.MODUL_DATA + "/" + fileName
					+ "" + Common.JSON2, json);

		} else if (name.equals(Common.STUNDENPLAN)) {
			createFile(Common.PATH + "" + Common.STUNDENPLAN_DATA + "/"
					+ fileName + "" + Common.JSON2, json);

		} else if (name.equals(Common.EVENT)) {
			createFile(Common.PATH + "" + Common.Event_DATA + "/" + fileName
					+ "" + Common.JSON2, json);

		} else if (name.equals(Common.LEHRKRAFTNEWS)) {
			createFile(Common.PATH + "" + Common.LEHRKRAFTNEWS_DATA + "/"
					+ fileName + "" + Common.JSON2, json);

		} else if (name.equals(Common.PROF_DATA)) {
			createFile(Common.PATH + "" + "" + Common.PROF_DATA + "/"
					+ fileName + "" + Common.JSON2, json);

		} else if (name.equals(Common.MODUL_ORD)) {
			writeFile(Common.PATH + "" + "" + fileName + "" + Common.JSON2,
					json);

		} else if (name.equals(Common.STUDIENDOKU)) {
			writeFile(Common.PATH + "" + Common.STUDIENDOKU_DATA + "/Doku"
					+ fileName + "" + Common.JSON2, json);

		}

		return false;
	}

	private static void createFile(String filePath, JSONObject json) {
		FileWriter fstream = null;
		try {

			@SuppressWarnings("unused")
			FileOutputStream fos = new FileOutputStream(filePath);
			fstream = new FileWriter(filePath);

		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedWriter out = new BufferedWriter(fstream);
		try {

			out.write(json.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}
		// Close the output stream
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void writeFile(String filePath, JSONObject json) {
		FileWriter fstream = null;
		try {

			fstream = new FileWriter(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedWriter out = new BufferedWriter(fstream);
		try {
			out.write(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Close the output stream
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String readFile(File file) {
		FileReader fr = null;
		try {
			fr = new FileReader(file.getAbsolutePath());
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		return brReadIn(new BufferedReader(fr));
	}

	private static String brReadIn(BufferedReader br) {

		try {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	private static void generateJSON(String s, String cons, String var) {

		try {
			writeJSON(cons, var, new JSONObject(s));

		} catch (JSONException e1) {
			e1.printStackTrace();
		}

	}

	public static void selectDialog() {
		final JDialog dialog = new JDialog();

		// stellt seine Komponenten in vertikaler Ausrichtung dar
		Box vBox = Box.createVerticalBox();
		// wir benutzen die zum dynamischen hinzufügen und entfernen von
		// Komponenten
		final Box dynamicBox = Box.createVerticalBox();

		// das label
		JLabel jsonTypeLabel = new JLabel("Select Type for creating Json-File");

		// combo box
		String[] possibilities = { Common.REGISTRATION, Common.STUDENT,
				Common.MODUL, Common.STUNDENPLAN, Common.EVENT,
				Common.LEHRKRAFTNEWS, Common.PROF_DATA, Common.MODUL_ORD,
				Common.STUDIENDOKU };
		final JComboBox jsonTypesCombo = new JComboBox(possibilities);
		jsonTypesCombo.setSelectedIndex(-1);

		// listener an die box
		jsonTypesCombo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dynamicBox.removeAll();
				if (e.getSource() instanceof JComboBox) {
					int selectionIndex = ((JComboBox) e.getSource())
							.getSelectedIndex();
					System.out.println(selectionIndex);

					if (selectionIndex == 0) {
						Box tempBox = Box.createVerticalBox();

						tempBox.add(new JLabel("Matrikelnr: "));

						final JTextField registrationMatrikelnrText = new JTextField();
						tempBox.add(registrationMatrikelnrText);

						tempBox.add(new JLabel("Password: "));

						final JTextField registrationPasswordText = new JTextField();
						tempBox.add(registrationPasswordText);

						JButton saveButton = new JButton("Save");
						saveButton.addActionListener(new ActionListener() {

							@SuppressWarnings("unused")
							@Override
							public void actionPerformed(ActionEvent e) {
								File file = new File(Common.PATH + "" + "/"
										+ "registration.json");
								if (!file.exists()) {
									try {
										FileOutputStream fos = new FileOutputStream(
												file.getAbsolutePath());
									} catch (FileNotFoundException e1) {
										e1.printStackTrace();
									}
								}
								Map<String, String> map = new HashMap<String, String>();
								map.put("RegistrationMatrikelnr",
										registrationMatrikelnrText.getText());
								map.put("RegistrationPassword",
										registrationPasswordText.getText());
								String source = new JSONObject(map).toString();
								if (file.exists()) {
									String source1 = readFile(file);
									if (source1 == null) {
										generateJSON(
												new String("{"
														+ Common.REGISTRATION
														+ ":["
														+ new JSONObject(map)
																.toString()
														+ "]}"),
												Common.REGISTRATION,
												Common.REGISTRATION);
									}
									if (source1 != null) {
										source1 = source1.substring(0,
												source1.length() - 2);
										source1 = source1.concat("," + source
												+ "]}");

										generateJSON(source1,
												Common.REGISTRATION,
												Common.REGISTRATION);
									}
								} else {
									generateJSON(new String("{"
											+ Common.REGISTRATION + ""
											+ new JSONObject(map).toString()
											+ "}"), Common.REGISTRATION,
											Common.REGISTRATION);

								}

							}

						});
						dynamicBox.add(tempBox);
						dynamicBox.add(saveButton);
					} else if (selectionIndex == 1) {
						Box tempBox = Box.createVerticalBox();
						tempBox.add(new JLabel("Matrikelnr.: "));

						final JTextField studentMatrikelnrText = new JTextField();
						tempBox.add(studentMatrikelnrText);

						tempBox.add(new JLabel("Firstname: "));

						final JTextField studentFirstNameText = new JTextField();
						tempBox.add(studentFirstNameText);

						tempBox.add(new JLabel("Name: "));

						final JTextField studentNameText = new JTextField();
						tempBox.add(studentNameText);

						tempBox.add(new JLabel("Degree course: "));

						final JTextField studentdegreeCourseText = new JTextField();
						tempBox.add(studentdegreeCourseText);

						tempBox.add(new JLabel("Semester: "));

						final JTextField studentSemesterText = new JTextField();
						tempBox.add(studentSemesterText);

						tempBox.add(new JLabel("Fachbereich: "));

						final JTextField studentFachbereichText = new JTextField();
						tempBox.add(studentFachbereichText);

						tempBox.add(new JLabel("StudienOrdnung: "));

						final JTextField studentOrdnungText = new JTextField();
						tempBox.add(studentOrdnungText);

						tempBox.add(new JLabel("Stundenplan: "));

						File file = new File(Common.PATH + ""
								+ "/StudenplanData/");
						final File[] file1 = file.listFiles();

						String[] stundenplaene = new String[file1.length];
						for (int i = 0; i < file1.length; i++) {
							stundenplaene[i] = file1[i].getName();
						}
						final JComboBox stundenPlanTypesCombo = new JComboBox(
								stundenplaene);
						stundenPlanTypesCombo.setSelectedIndex(-1);
						tempBox.add(stundenPlanTypesCombo);

						JButton saveButton = new JButton("Save");

						saveButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {

								Map<String, String> map = new HashMap<String, String>();
								map.put("Matrikelnr",
										studentMatrikelnrText.getText());
								map.put("FirstName",
										studentFirstNameText.getText());
								map.put("Name", studentNameText.getText());
								map.put("DegreeCourse",
										studentdegreeCourseText.getText());
								map.put("Semester",
										studentSemesterText.getText());
								map.put("Fachbereich",
										studentFachbereichText.getText());
								map.put("StudienOrdnung",
										studentOrdnungText.getText());
								JSONObject json = new JSONObject(map);

								String source1 = readFile(file1[stundenPlanTypesCombo
										.getSelectedIndex()]);
								String source = json.toString();

								source = source.substring(0,
										source.length() - 1);

								source = source.concat("," + Common.STUNDENPLAN
										+ ":" + source1 + "}");
								generateJSON(source, Common.STUDENT,
										studentMatrikelnrText.getText());

							}
						});
						dynamicBox.add(tempBox);
						dynamicBox.add(saveButton);

					} else if (selectionIndex == 2) {
						Box tempBox = Box.createVerticalBox();
						tempBox.add(new JLabel("Modul: "));

						final JTextField coursesModulText = new JTextField();
						tempBox.add(coursesModulText);

						tempBox.add(new JLabel("Teacher: "));

						final JTextField coursesTeacherText = new JTextField();
						tempBox.add(coursesTeacherText);

						tempBox.add(new JLabel("Room: "));

						final JTextField coursesRoomText = new JTextField();
						tempBox.add(coursesRoomText);

						tempBox.add(new JLabel("Day: "));

						final JTextField coursesDayText = new JTextField();
						tempBox.add(coursesDayText);

						tempBox.add(new JLabel("Time: "));

						final JTextField coursesTimeText = new JTextField();
						tempBox.add(coursesTimeText);

						tempBox.add(new JLabel("GueltigNStudienOrdnung: "));

						final JTextField coursesModulOrdnungText = new JTextField();
						tempBox.add(coursesModulOrdnungText);

						JButton saveButton = new JButton("Save");

						saveButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								Map<String, String> map = new HashMap<String, String>();
								map.put("ModulName", coursesModulText.getText());
								map.put("Teacher", coursesTeacherText.getText());
								map.put("Room", coursesRoomText.getText());
								map.put("Day", coursesDayText.getText());
								map.put("Time", coursesTimeText.getText());
								map.put("GueltigNStudienOrdnung",
										coursesModulOrdnungText.getText());
								JSONObject json = new JSONObject(map);
								writeJSON(Common.MODUL,
										coursesModulText.getText(), json);

							}
						});
						dynamicBox.add(tempBox);
						dynamicBox.add(saveButton);

					} else if (selectionIndex == 3) {
						Box tempBox = Box.createVerticalBox();
						File file = new File(Common.PATH + ""
								+ Common.MODUL_DATA + "/");
						final File[] file1 = file.listFiles();
						String[] module = new String[file1.length];
						for (int i = 0; i < file1.length; i++) {
							module[i] = file1[i].getName();
						}

						tempBox.add(new JLabel("Stundenplan: "));

						final JTextField stundenplanText = new JTextField();
						tempBox.add(stundenplanText);

						tempBox.add(new JLabel("Modul1: "));

						final JComboBox modul1TypesCombo = new JComboBox(module);
						modul1TypesCombo.setSelectedIndex(-1);

						tempBox.add(modul1TypesCombo);

						tempBox.add(new JLabel("Modul2: "));

						final JComboBox modul2TypesCombo = new JComboBox(module);
						modul2TypesCombo.setSelectedIndex(-1);

						tempBox.add(modul2TypesCombo);

						tempBox.add(new JLabel("Modul3: "));

						final JComboBox modul3TypesCombo = new JComboBox(module);
						modul3TypesCombo.setSelectedIndex(-1);

						tempBox.add(modul3TypesCombo);

						tempBox.add(new JLabel("Modul4: "));

						final JComboBox modul4TypesCombo = new JComboBox(module);
						modul4TypesCombo.setSelectedIndex(-1);

						tempBox.add(modul4TypesCombo);

						JButton saveButton = new JButton("Save");

						saveButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								Map<String, String> map = new HashMap<String, String>();
								map.put("StundenplanName",
										stundenplanText.getText());
								String jsonString = new String((new JSONObject(
										map)).toString());
								jsonString = jsonString.substring(0,
										jsonString.length() - 1);

								String source1 = readFile(file1[modul1TypesCombo
										.getSelectedIndex()]);
								String source2 = readFile(file1[modul2TypesCombo
										.getSelectedIndex()]);
								String source3 = readFile(file1[modul3TypesCombo
										.getSelectedIndex()]);
								String source4 = readFile(file1[modul1TypesCombo
										.getSelectedIndex()]);

								jsonString = jsonString.concat(new String(","
										+ Common.MODUL + ":[" + source1 + ","
										+ source2 + "," + source3 + ","
										+ source4 + "]}"));
								generateJSON(jsonString, Common.STUNDENPLAN,
										stundenplanText.getText());

							}
						});

						dynamicBox.add(tempBox);
						dynamicBox.add(saveButton);

					} else if (selectionIndex == 4) {
						Box tempBox = Box.createVerticalBox();

						tempBox.add(new JLabel("Eventtitle: "));

						final JTextField eventTitleText = new JTextField();
						tempBox.add(eventTitleText);

						tempBox.add(new JLabel("Day: "));

						final JTextField eventDayText = new JTextField();
						tempBox.add(eventDayText);

						tempBox.add(new JLabel("Time: "));

						final JTextField eventTimeText = new JTextField();
						tempBox.add(eventTimeText);

						JButton saveButton = new JButton("Save");

						saveButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								Map<String, String> map = new HashMap<String, String>();
								map.put("Eventtitle", eventTitleText.getText());
								map.put("Day", eventDayText.getText());
								map.put("Time", eventTimeText.getText());

								JSONObject json = new JSONObject(map);
								writeJSON(Common.EVENT,
										eventTitleText.getText(), json);

							}
						});

						dynamicBox.add(tempBox);
						dynamicBox.add(saveButton);

					} else if (selectionIndex == 5) {
						Box tempBox = Box.createVerticalBox();
						tempBox.add(new JLabel("LehrkraftnewsName: "));

						final JTextField lehrkraftNewsNameText = new JTextField();
						tempBox.add(lehrkraftNewsNameText);

						tempBox.add(new JLabel("Prof: "));

						final JTextField lehrkraftNewsProfText = new JTextField();
						tempBox.add(lehrkraftNewsProfText);

						tempBox.add(new JLabel("Description: "));

						final JTextField lehrkraftNewsDescriptionText = new JTextField();
						tempBox.add(lehrkraftNewsDescriptionText);

						JButton saveButton = new JButton("Save");
						saveButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								Map<String, String> map = new HashMap<String, String>();
								map.put("LehrkraftnewsName",
										lehrkraftNewsNameText.getText());
								map.put("Prof", lehrkraftNewsProfText.getText());
								map.put("Description",
										lehrkraftNewsDescriptionText.getText());

								writeJSON(Common.LEHRKRAFTNEWS,
										lehrkraftNewsNameText.getText(),
										new JSONObject(map));

							}
						});
						dynamicBox.add(tempBox);
						dynamicBox.add(saveButton);
					} else if (selectionIndex == 6) {
						Box tempBox = Box.createVerticalBox();

						tempBox.add(new JLabel("ProfName: "));

						final JTextField profNameText = new JTextField();
						tempBox.add(profNameText);

						tempBox.add(new JLabel("Website: "));

						final JTextField profWebsiteText = new JTextField();
						tempBox.add(profWebsiteText);

						JButton saveButton = new JButton("Save");

						saveButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								Map<String, String> map = new HashMap<String, String>();
								map.put("ProfName", profNameText.getText());
								map.put("Website", profWebsiteText.getText());

								JSONObject json = new JSONObject(map);
								writeJSON(Common.PROF_DATA,
										profNameText.getText(), json);

							}
						});

						dynamicBox.add(tempBox);
						dynamicBox.add(saveButton);

					} else if (selectionIndex == 7) {
						Box tempBox = Box.createVerticalBox();

						tempBox.add(new JLabel("Modul: "));

						final JTextField modulOrdNameText = new JTextField();
						tempBox.add(modulOrdNameText);

						tempBox.add(new JLabel("ModulDescription: "));

						final JTextField modulOrdDescriptionText = new JTextField();
						tempBox.add(modulOrdDescriptionText);

						tempBox.add(new JLabel("ModulNOrd: "));

						final JTextField modulNOrdText = new JTextField();
						tempBox.add(modulNOrdText);

						JButton saveButton = new JButton("Save");

						saveButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								File file = new File(Common.PATH + "" + "/"
										+ modulNOrdText.getText() + ""
										+ Common.JSON2);

								Map<String, String> map = new HashMap<String, String>();
								map.put("ModulNameOrd",
										modulOrdNameText.getText());
								map.put("ModulDescriptionOrd:",
										modulOrdDescriptionText.getText());
								map.put("ModulNOrd:", modulNOrdText.getText());

								JSONObject json = new JSONObject(map);
								if (!file.exists()) {

									try {
										@SuppressWarnings("unused")
										FileOutputStream fos = new FileOutputStream(
												file.getAbsolutePath());
									} catch (FileNotFoundException e1) {
										e1.printStackTrace();
									}
									generateJSON(new String("{\"ModulOrd\":["
											+ json.toString() + "]}"),
											Common.MODUL_ORD,
											modulNOrdText.getText());

								}

								String source = readFile(file);
								source = source.substring(0,
										source.length() - 2);

								generateJSON(
										new String(source + ","
												+ json.toString() + "]}"),
										Common.MODUL_ORD,
										modulNOrdText.getText());
							}
						});

						dynamicBox.add(tempBox);
						dynamicBox.add(saveButton);

					} else if (selectionIndex == 8) {
						Box tempBox = Box.createVerticalBox();
						tempBox.add(new JLabel("dokuMatrikelnr: "));

						final JTextField dokuMatrikelnrText = new JTextField();
						tempBox.add(dokuMatrikelnrText);

						tempBox.add(new JLabel("Modul: "));

						final JTextField dokuModulText = new JTextField();
						tempBox.add(dokuModulText);

						tempBox.add(new JLabel("Credits: "));

						final JTextField dokuCreditsText = new JTextField();
						tempBox.add(dokuCreditsText);

						tempBox.add(new JLabel("Note: "));

						final JTextField dokuNoteText = new JTextField();
						tempBox.add(dokuNoteText);

						tempBox.add(new JLabel("Teacher: "));

						final JTextField dokuTeacherText = new JTextField();
						tempBox.add(dokuTeacherText);

						tempBox.add(new JLabel("Versuch: "));

						final JTextField dokuVersuchText = new JTextField();
						tempBox.add(dokuVersuchText);

						tempBox.add(new JLabel("Belegung: "));

						final JTextField dokuBelegungText = new JTextField();
						tempBox.add(dokuBelegungText);

						JButton saveButton = new JButton("Save");

						saveButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								Map<String, String> map = new HashMap<String, String>();
								map.put("DokuModul", dokuModulText.getText());
								map.put("DokuCredits",
										dokuCreditsText.getText());
								map.put("DokuNote", dokuNoteText.getText());
								map.put("DokuTeacher",
										dokuTeacherText.getText());
								map.put("DokuVersuch",
										dokuVersuchText.getText());
								map.put("DokuBelegung",
										dokuBelegungText.getText());

								JSONObject json = new JSONObject(map);
								// writeJSON(MODUL,
								// dokuMatrikelnrText.getText(),
								// json);
								File file = new File(Common.PATH + ""
										+ "/StudiendokuData/Doku"
										+ dokuMatrikelnrText.getText() + ""
										+ Common.JSON2);
								System.out.println(file.getAbsolutePath());

								if (!file.exists()) {

									try {
										@SuppressWarnings("unused")
										FileOutputStream fos = new FileOutputStream(
												file.getAbsolutePath());
									} catch (FileNotFoundException e1) {
										e1.printStackTrace();
									}

									generateJSON(
											new String("{\"StudienDoku\":["
													+ json.toString() + "]}"),
											Common.STUDIENDOKU,
											dokuMatrikelnrText.getText());

								}

								String source = new JSONObject(map).toString();

								String source1 = readFile(file);

								if (source1 == null) {
									generateJSON(
											new String("{"
													+ "StudienDoku"
													+ ":["
													+ new JSONObject(map)
															.toString() + "]}"),
											Common.STUDIENDOKU,
											dokuMatrikelnrText.getText());

								} else if (source1 != null) {
									source1 = source1.substring(0,
											source1.length() - 2);
									source1 = source1.concat("," + source
											+ "]}");
									generateJSON(source1, Common.STUDIENDOKU,
											dokuMatrikelnrText.getText());

								}
							}
						});
						dynamicBox.add(tempBox);
						dynamicBox.add(saveButton);

					}

					dialog.pack();
				}

			}
		});

		vBox.add(jsonTypeLabel);
		vBox.add(jsonTypesCombo);
		vBox.add(dynamicBox);

		dialog.add(vBox);

		dialog.setModal(true);
		dialog.setTitle("Json Type Generation Dialog");
		dialog.pack();
		dialog.setVisible(true);
	}

}
