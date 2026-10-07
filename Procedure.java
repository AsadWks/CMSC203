
public class Procedure {
	
	private String nameOfProcedure;
	private String dateOfProcedure;
	private String nameOfPractitioner;
	private String chargesForProcedure;
	
	public Procedure() {
		
		
	}
	
	public Procedure(String nameOfProcedure, String dateOfProcedure) {
		
		this.nameOfProcedure = nameOfProcedure;
		this.dateOfProcedure = dateOfProcedure;
		
	}

	public Procedure(String nameOfProcedure, String dateOfProcedure, String nameOfPractitioner, String chargesForProcedure) {
		
		this.nameOfProcedure = nameOfProcedure;
		this.dateOfProcedure = dateOfProcedure;
		this.nameOfPractitioner = nameOfPractitioner;
		this.chargesForProcedure = chargesForProcedure;
		
	}
	
	
	@Override
	public String toString() {
		
	    return "\tProcedure: " + nameOfProcedure + "\n"
	            + "\tProcedure Date: " + dateOfProcedure + "\n"
	            + "\tPractitioner: " + nameOfPractitioner + "\n"
	            + "\tCharge: $" + chargesForProcedure;
	    
	}
	
	
	
	
	
	public void setNameOfProcedure(String nameOfProcedure) {
		
		this.nameOfProcedure = nameOfProcedure;
		
	}
	
	public String getNameOfProcedure() {
		
		return nameOfProcedure;
		
	}
	
	public void setDateOfProcedure(String dateOfProcedure) {
		
		this.dateOfProcedure = dateOfProcedure;
		
	}
	
	public String getDateOfProcedure() {
		
		return dateOfProcedure;
		
	}
	
	public void setNameOfPractitioner(String nameOfPractitioner) {
		
		this.nameOfPractitioner = nameOfPractitioner;
		
	}
	
	public String getNameOfPractitioner() {
		
		return nameOfPractitioner;
		
	}
	
	public void setChargesForProcedure(String chargesForProcedure) {
		
		this.chargesForProcedure = chargesForProcedure;
		
	}
	
	public String getChargesForProcedure() {
		
		return chargesForProcedure;
		
	}

}
