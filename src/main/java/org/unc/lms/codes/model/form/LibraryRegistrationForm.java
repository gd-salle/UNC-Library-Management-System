package org.unc.lms.codes.model.form;

public class LibraryRegistrationForm {

	private String userType; 
	private String studentId;
	private String ezName; 
	private String password; 
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private String uncEmail;
    private String phoneNum;
    private String department; 
    private String yearLevel; 
    private String course;
    private String libraryCardNumber; 
    
   
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getUncEmail() {
		return uncEmail;
	}
	public void setUncEmail(String uncEmail) {
		this.uncEmail = uncEmail;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getEzName() {
		return ezName;
	}
	public void setEzName(String ezName) {
		this.ezName = ezName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getYearLevel() {
		return yearLevel;
	}
	public void setYearLevel(String yearLevel) {
		this.yearLevel = yearLevel;
	}
	public String getLibraryCardNumber() {
		return libraryCardNumber;
	}
	public void setLibraryCardNumber(String libraryCardNumber) {
		this.libraryCardNumber = libraryCardNumber;
	}
    
	public String getFullName() {
        StringBuilder fullName = new StringBuilder();

        if (firstName != null) {
            fullName.append(firstName);
        }

        if (middleName != null && !middleName.isEmpty()) {
            fullName.append(" ").append(middleName.charAt(0)).append(".");
        }

        if (lastName != null) {
            fullName.append(" ").append(lastName);
        }

        if (suffix != null) {
            fullName.append(" ").append(suffix);
        }

        return fullName.toString().trim();
    }

    
}
