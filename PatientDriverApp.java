/*
 * Class: CMSC203 
 * Instructor: Professor Ahmed Tarek
 * Description: A GUI that can take in information about a patient and their procedures and be able to output that information
 * Due: 09/30/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Asad Hanif
*/

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PatientDriverApp {
	
	private static JTextArea outputArea;

	public static void main(String[] args) {
		
		// Creating a frame object and a panel object that is formatted with a grid
		JFrame frame = new JFrame("Patient and Procedure Info");
		JPanel patientInfoPanel = new JPanel(new GridLayout(11, 2)); // Panel will hold info concerning patient information
		JPanel proceduresPanel = new JPanel(new GridLayout(1, 3));
		
		// Formatting the frame
		frame.setSize(1500, 1500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(patientInfoPanel, BorderLayout.WEST);
		frame.add(proceduresPanel, BorderLayout.CENTER);
		
		// Giving the panel a border with a name
		patientInfoPanel.setBorder(BorderFactory.createTitledBorder("Patient Information"));
		
		// Creating labels and fields as per the grid for each piece of information needed from user
		JLabel firstNameLabel = new JLabel("First Name: ");
		JTextField firstNameField = new JTextField(15);
		
		JLabel middleNameLabel = new JLabel("Middle Name: ");
		JTextField middleNameField = new JTextField(15);
		
		JLabel lastNameLabel = new JLabel("Last Name: ");
		JTextField lastNameField = new JTextField(15);
		
		JLabel addressLabel = new JLabel("Address: ");
		JTextField addressField = new JTextField(15);
		
		JLabel cityLabel = new JLabel("City: ");
		JTextField cityField = new JTextField(15);
		
		JLabel stateLabel = new JLabel("State: ");
		JTextField stateField = new JTextField(15);
		
		JLabel zipLabel = new JLabel("ZIP: ");
		JTextField zipField = new JTextField(15);
		
		JLabel phoneLabel = new JLabel("Phone: ");
		JTextField phoneField = new JTextField(15);
		
		JLabel emergencyNameLabel = new JLabel("Emergency Name: ");
		JTextField emergencyNameField = new JTextField(15);
		
		JLabel emergencyPhoneLabel = new JLabel("Emergency Phone: ");
		JTextField emergencyPhoneField = new JTextField(15);
		
		// Adding the labels and fields to the panel in accordance to the grid
		patientInfoPanel.add(firstNameLabel);
		patientInfoPanel.add(firstNameField);
		
		patientInfoPanel.add(middleNameLabel);
		patientInfoPanel.add(middleNameField);
		
		patientInfoPanel.add(lastNameLabel);
		patientInfoPanel.add(lastNameField);
		
		patientInfoPanel.add(addressLabel);
		patientInfoPanel.add(addressField);
		
		patientInfoPanel.add(cityLabel);
		patientInfoPanel.add(cityField);
		
		patientInfoPanel.add(stateLabel);
		patientInfoPanel.add(stateField);
		
		patientInfoPanel.add(zipLabel);
		patientInfoPanel.add(zipField);
		
		patientInfoPanel.add(phoneLabel);
		patientInfoPanel.add(phoneField);
		
		patientInfoPanel.add(emergencyNameLabel);
		patientInfoPanel.add(emergencyNameField);
		
		patientInfoPanel.add(emergencyPhoneLabel);
		patientInfoPanel.add(emergencyPhoneField);
		
		
		// Creating a save button that will save the patients information
		JButton savePatientButton = new JButton("Save Patient");
		patientInfoPanel.add(savePatientButton);
		
		Patient patient = new Patient();
		
		
		Procedure procedure1 = new Procedure();
		Procedure procedure2 = new Procedure("", "");
		Procedure procedure3 = new Procedure("", "", "", "");
		
		
		
		// Making the save button interactive
		savePatientButton.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Creating variables accordingly to the text the user enters into the field
				String firstName = firstNameField.getText();
				String middleName = middleNameField.getText();
				String lastName = lastNameField.getText();

				String address = addressField.getText();
				String city = cityField.getText();
				String state = stateField.getText();
				String zip = zipField.getText();

				String phone = phoneField.getText();

				String emergencyName = emergencyNameField.getText();
				String emergencyPhone = emergencyPhoneField.getText();
				
				patient.setFirstName(firstName);
				patient.setMiddleName(middleName);
				patient.setLastName(lastName);
				
				patient.setStrtAddress(address);
				patient.setCity(city);
				patient.setState(state);
				patient.setZipCode(zip);
				
				patient.setPhoneNumber(phone);
				
				patient.setEmergName(emergencyName);
				patient.setEmergPhone(emergencyPhone);
				
				JOptionPane.showMessageDialog(frame, 
				        "Patient information saved.", 
				        "Message", 
				        JOptionPane.INFORMATION_MESSAGE);
			
			}
			
		});		
		
		
		
		// Code from here on refers to the procedure panel
		
		JPanel procedure1Panel = new JPanel(new GridLayout(5, 2));

		procedure1Panel.setBorder(
		        BorderFactory.createTitledBorder("Procedure 1"));
		
		// Creating labels and fields for the first procedure panel
		JLabel procedure1NameLabel = new JLabel("Name:");
		JTextField procedure1NameField = new JTextField();

		JLabel procedure1DateLabel = new JLabel("Date:");
		JTextField procedure1DateField = new JTextField();

		JLabel procedure1PractitionerLabel = new JLabel("Practitioner:");
		JTextField procedure1PractitionerField = new JTextField();

		JLabel procedure1ChargeLabel = new JLabel("Charge ($):");
		JTextField procedure1ChargeField = new JTextField();

		JButton saveProcedure1Button = new JButton("Save Procedure 1");
		
		
		// Adding the procedure 1 contents to the procedure 1 panel		
		procedure1Panel.add(procedure1NameLabel);
		procedure1Panel.add(procedure1NameField);

		procedure1Panel.add(procedure1DateLabel);
		procedure1Panel.add(procedure1DateField);

		procedure1Panel.add(procedure1PractitionerLabel);
		procedure1Panel.add(procedure1PractitionerField);

		procedure1Panel.add(procedure1ChargeLabel);
		procedure1Panel.add(procedure1ChargeField);

		procedure1Panel.add(saveProcedure1Button);
		
		// Adds all of the contents of procedure 1 into the overarching procedure panel
		proceduresPanel.add(procedure1Panel);
		
		// Makes save button for procedure 1 interactive
		saveProcedure1Button.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {

		        String name = procedure1NameField.getText();
		        String date = procedure1DateField.getText();
		        String practitioner = procedure1PractitionerField.getText();
		        String charge = procedure1ChargeField.getText();

		        procedure1.setNameOfProcedure(name);
		        procedure1.setDateOfProcedure(date);
		        procedure1.setNameOfPractitioner(practitioner);
		        procedure1.setChargesForProcedure(charge);
		        
		        JOptionPane.showMessageDialog(frame, 
		                "Procedure 1 information saved.", 
		                "Message", 
		                JOptionPane.INFORMATION_MESSAGE);
		        
		    }

		});
		
		
		
		
		
		
		
		// Creates the second procedure panel
		JPanel procedure2Panel = new JPanel(new GridLayout(5, 2));

		procedure2Panel.setBorder(
		        BorderFactory.createTitledBorder("Procedure 2"));
		
		// Creating labels and fields for the 2nd procedure panel
		JLabel procedure2NameLabel = new JLabel("Name:");
		JTextField procedure2NameField = new JTextField();

		JLabel procedure2DateLabel = new JLabel("Date:");
		JTextField procedure2DateField = new JTextField();

		JLabel procedure2PractitionerLabel = new JLabel("Practitioner:");
		JTextField procedure2PractitionerField = new JTextField();

		JLabel procedure2ChargeLabel = new JLabel("Charge ($):");
		JTextField procedure2ChargeField = new JTextField();

		JButton saveProcedure2Button = new JButton("Save Procedure 2");
		
		
		// Adding the procedure 2 contents to the procedure 2 panel		
		procedure2Panel.add(procedure2NameLabel);
		procedure2Panel.add(procedure2NameField);

		procedure2Panel.add(procedure2DateLabel);
		procedure2Panel.add(procedure2DateField);

		procedure2Panel.add(procedure2PractitionerLabel);
		procedure2Panel.add(procedure2PractitionerField);

		procedure2Panel.add(procedure2ChargeLabel);
		procedure2Panel.add(procedure2ChargeField);

		procedure2Panel.add(saveProcedure2Button);

		
		// Adds all of the contents of procedure 2 into the overarching procedure panel
		proceduresPanel.add(procedure2Panel);
		
		// Makes save button for procedure 2 interactive
		saveProcedure2Button.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {

		        String name = procedure2NameField.getText();
		        String date = procedure2DateField.getText();
		        String practitioner = procedure2PractitionerField.getText();
		        String charge = procedure2ChargeField.getText();

		        procedure2.setNameOfProcedure(name);
		        procedure2.setDateOfProcedure(date);
		        procedure2.setNameOfPractitioner(practitioner);
		        procedure2.setChargesForProcedure(charge);
		        
		        JOptionPane.showMessageDialog(frame, 
		                "Procedure 2 information saved.", 
		                "Message", 
		                JOptionPane.INFORMATION_MESSAGE);
		        
		    }
		});
		
		
		
		
		
		
		// Creates the 3rd procedure panel
		JPanel procedure3Panel = new JPanel(new GridLayout(5, 2));

		procedure3Panel.setBorder(
		        BorderFactory.createTitledBorder("Procedure 3"));

		// Creating labels and fields for the 3rd procedure panel
		JLabel procedure3NameLabel = new JLabel("Name:");
		JTextField procedure3NameField = new JTextField();

		JLabel procedure3DateLabel = new JLabel("Date:");
		JTextField procedure3DateField = new JTextField();

		JLabel procedure3PractitionerLabel = new JLabel("Practitioner:");
		JTextField procedure3PractitionerField = new JTextField();

		JLabel procedure3ChargeLabel = new JLabel("Charge ($):");
		JTextField procedure3ChargeField = new JTextField();

		JButton saveProcedure3Button = new JButton("Save Procedure 3");
		
		
		// Adding the procedure 3 contents to the procedure 3 panel		
		procedure3Panel.add(procedure3NameLabel);
		procedure3Panel.add(procedure3NameField);

		procedure3Panel.add(procedure3DateLabel);
		procedure3Panel.add(procedure3DateField);

		procedure3Panel.add(procedure3PractitionerLabel);
		procedure3Panel.add(procedure3PractitionerField);

		procedure3Panel.add(procedure3ChargeLabel);
		procedure3Panel.add(procedure3ChargeField);

		procedure3Panel.add(saveProcedure3Button);

		
		// Adds all of the contents of procedure 3 into the overarching procedure panel
		proceduresPanel.add(procedure3Panel);
		
		// Makes save button for procedure 3 interactive
		saveProcedure3Button.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {

		        String name = procedure3NameField.getText();
		        String date = procedure3DateField.getText();
		        String practitioner = procedure3PractitionerField.getText();
		        String charge = procedure3ChargeField.getText();

		        procedure3.setNameOfProcedure(name);
		        procedure3.setDateOfProcedure(date);
		        procedure3.setNameOfPractitioner(practitioner);
		        procedure3.setChargesForProcedure(charge);
		        
		        JOptionPane.showMessageDialog(frame, 
		                "Procedure 3 information saved.", 
		                "Message", 
		                JOptionPane.INFORMATION_MESSAGE);
		        
		    }
		});
		
		
		
		// Creates the output area
		JPanel outputPanel = new JPanel(new BorderLayout());
		outputPanel.setBorder(BorderFactory.createTitledBorder("Output"));

		outputArea = new JTextArea(20, 50);
		outputArea.setEditable(false);

		JButton showOutputButton = new JButton("Show Output");
		JButton exitButton = new JButton("Exit");

		outputPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);

		JPanel outputButtonPanel = new JPanel();
		outputButtonPanel.add(showOutputButton);
		outputButtonPanel.add(exitButton);

		outputPanel.add(outputButtonPanel, BorderLayout.SOUTH);

		frame.add(outputPanel, BorderLayout.SOUTH);
		
		
		// Displays output upon pressing the "Show Output" button
		showOutputButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {

		    	outputArea.append("Patient Information\n");
		    	displayPatient(patient);

		    	outputArea.append("\nProcedure 1\n");
		    	displayProcedure(procedure1);

		    	outputArea.append("\nProcedure 2\n");
		    	displayProcedure(procedure2);

		    	outputArea.append("\nProcedure 3\n");
		    	displayProcedure(procedure3);

		    	double total = calculateTotalCharges(procedure1, procedure2, procedure3);

		    	outputArea.append("\nTotal Charges: $" + String.format("%,.2f", total));
		    	outputArea.append("\n\nProgram by: Asad Hanif");
		    	
		    }
		    
		});
		
		// Exits the program upon clicking exit button
		exitButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        System.exit(0);
		    }
		    
		});
		
		
			
		
		
		
		
		frame.setVisible(true);

	}
	
	// Method to display patient info
	public static void displayPatient(Patient patient) {
		
	    outputArea.append(patient.toString());
	    outputArea.append("\n");
	    
	}
	
	// Method to display procedure info
	public static void displayProcedure(Procedure procedure) {
		
	    outputArea.append(procedure.toString());
	    outputArea.append("\n");
	    
	}
	
	// Method that calculates total charges by converting initial String values into double values that we can work with and manipulate
	public static double calculateTotalCharges(Procedure procedure1, Procedure procedure2, Procedure procedure3) {
		
	    double charge1 = Double.parseDouble(procedure1.getChargesForProcedure());
	    double charge2 = Double.parseDouble(procedure2.getChargesForProcedure());
	    double charge3 = Double.parseDouble(procedure3.getChargesForProcedure());

	    return charge1 + charge2 + charge3;
	    
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
