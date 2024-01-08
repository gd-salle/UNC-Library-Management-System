package org.unc.lms.codes.model.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	
    private String studentId;
    private String ezName; 
    private String password; 
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private String uncEmail;
    private String phoneNum;
    private String deptId; 
    private String courseId; 
    private String userType; 
    private String libraryCardNumber; 
    private String yearLevel; 

    
    @Id
    @Column(name = "student_id", length = 50, nullable = false, unique = true)
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	@Column(name = "ez_name", length = 50, nullable = true)
	public String getEzName() {
		return ezName;
	}
	public void setEzName(String ezName) {
		this.ezName = ezName;
	}
	@Column(name = "password", nullable = true)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "first_name", length = 50, nullable = false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name = "middle_name", length = 50, nullable = true)
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	@Column(name = "last_name", length = 50, nullable = false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column(name = "suffix", length = 5, nullable = true)
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	@Column(name = "unc_email", length = 100, nullable = false)
	public String getUncEmail() {
		return uncEmail;
	}
	public void setUncEmail(String uncEmail) {
		this.uncEmail = uncEmail;
	}
	@Column(name = "phone_num", length = 20, nullable = false)
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	@Column(name = "dept_id", length = 10, nullable = true)
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	@Column(name = "course_id", length = 50, nullable = true)
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	@Column(name = "user_type", length = 20, nullable = true)
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Column(name = "librarycard_number", length = 20, nullable = true)
	public String getLibraryCardNumber() {
		return libraryCardNumber;
	}
	public void setLibraryCardNumber(String libraryCardNumber) {
		this.libraryCardNumber = libraryCardNumber;
	}
	@Column(name = "yearlevel", length = 20, nullable = true)
	public String getYearLevel() {
		return yearLevel;
	}
	public void setYearLevel(String yearLevel) {
		this.yearLevel = yearLevel;
	}
	
//	public String getFullName() {
//        StringBuilder fullName = new StringBuilder();
//
//        if (firstName != null) {
//            fullName.append(firstName);
//        }
//
//        if (middleName != null && !middleName.isEmpty()) {
//            fullName.append(" ").append(middleName.charAt(0)).append(".");
//        }
//
//        if (lastName != null) {
//            fullName.append(" ").append(lastName);
//        }
//
//        if (suffix != null) {
//            fullName.append(" ").append(suffix);
//        }
//
//        return fullName.toString().trim();
//	}
//	public void setFullName(String fullName) {
//		this.fullName = fullName; 
//	}
	 
}
