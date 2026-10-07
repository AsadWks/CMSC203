
public class Patient {

	private String firstName, middleName, lastName;
	private String strtAddress, city, state;
	
	private String zipCode;
	private String phoneNumber;
	
	private String emergName;
	private String emergPhone;
	
	public Patient() {
		
		
	}
	
	public Patient(String firstName, String middleName, String lastName) {
		
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		
	}
	
	public Patient (String strtAddress, String city, String state, String zipCode, String phoneNumber,
					String emergName, String emergPhone) {
		
		this.strtAddress = strtAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		this.emergName = emergName;
		this.emergPhone = emergPhone;
		
	}
	
	
	public String buildFullName() {
		
		return firstName + " " + middleName + " " + lastName;
	}
	
	public String buildAddress() {
		
		return strtAddress + " " + city + " " + state + " " + zipCode;
		
	}
	
	public String buildEmergencyContact() {
		
		return emergName + " " + emergPhone;
		
	}
	
	@Override
	public String toString() {
		
	    return "Patient info:\n"
	            + "\tName: " + buildFullName() + "\n"
	            + "\tAddress: " + buildAddress() + "\n"
	            + "\tEmergency Contact: " + buildEmergencyContact();
	    
	}
	
	
	
	
	
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setMiddleName(String middleName) {
		
		this.middleName = middleName;
		
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public void setLastName(String lastName) {
		
		this.lastName = lastName;
		
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setStrtAddress(String strtAddress) {
		
		this.strtAddress = strtAddress;
		
	}
	
	public String getStrtAddress() {
		return strtAddress;
	}
	
	public void setCity(String city) {
		
		this.city = city;
		
	}
	
	public String getCity() {
		return city;
	}
	
	public void setState(String state) {
		
		this.state = state;
		
	}
	
	public String getState() {
		return state;
	}
	
	public void setZipCode(String zipCode) {
		
		this.zipCode = zipCode;
		
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		
		this.phoneNumber = phoneNumber;
		
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setEmergName(String emergName) {
		
		this.emergName = emergName;
		
	}
	
	public String getEmergName() {
		return emergName;
	}
	
	public void setEmergPhone(String emergPhone) {
		
		this.emergPhone = emergPhone;
		
	}
	
	public String getEmergPhone() {
		return emergPhone;
	}
	
	
	
	
}
