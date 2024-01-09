package org.unc.lms.codes.services;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.unc.lms.codes.model.data.User;
import org.unc.lms.codes.model.form.LibraryRegistrationForm;
import org.unc.lms.codes.repository.StudentRepository;
import org.unc.lms.codes.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	public UserRepository userRepository; 
	@Autowired
	public StudentRepository studentRepository; 
	@Autowired
	public DepartmentService departmentService; 
	@Autowired
	public CoursesService coursesService; 
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private static Logger logger = Logger.getLogger(StudentRepository.class.getName());
	
	
	public User adduser(User user) {
		return userRepository.save(user); 
	}
	
	
	public User addStudentData(LibraryRegistrationForm libraryRegistrationForm) {
		String deptName = libraryRegistrationForm.getDepartment();
		String courseName = libraryRegistrationForm.getCourse(); 
		
        String deptId = departmentService.getDeptIdByDeptName(deptName);
        String courseId = coursesService.getCourseIdByCourseName(courseName); 
        
        String rawPassword = libraryRegistrationForm.getPassword(); 
        String encodePassword = passwordEncoder.encode(rawPassword); 
        
        try {
            // Map data from LibraryRegistrationForm to User
            User user = new User();
            user.setStudentId(libraryRegistrationForm.getStudentId());
            user.setEzName(libraryRegistrationForm.getEzName());
            user.setPassword(encodePassword);
            user.setFirstName(libraryRegistrationForm.getFirstName());
            user.setMiddleName(libraryRegistrationForm.getMiddleName());
            user.setLastName(libraryRegistrationForm.getLastName());
            user.setSuffix(libraryRegistrationForm.getSuffix());
            user.setUncEmail(libraryRegistrationForm.getUncEmail());
            user.setCourseId(courseId);
            user.setPhoneNum(libraryRegistrationForm.getPhoneNum());
            user.setDeptId(deptId);
            user.setUserType(libraryRegistrationForm.getUserType());
            user.setLibraryCardNumber(libraryRegistrationForm.getLibraryCardNumber());
            user.setYearLevel(libraryRegistrationForm.getYearLevel());

            // Save the user to the database
            return userRepository.save(user);
        } catch (Exception e) {
            logger.severe(e.getMessage());
            return null;
        }
	} 
	
	public Optional<User> getStudentData(String libraryCardNumber) { 
		return userRepository.findByLibraryCardNumber(libraryCardNumber); 
	}
	
	public Optional<User> findStudentByStudentIdAndPassword(String libraryCardNumber, String password) {
        return userRepository.findByLibraryCardNumberAndPassword(libraryCardNumber, password);
    }
	
	
	public UserDetails loadUserByUsername(String libraryCardNumber) throws UsernameNotFoundException {
	    Optional<User> userOptional = userRepository.findByLibraryCardNumber(libraryCardNumber);
	    
	    User user = userOptional.orElseThrow(() -> new UsernameNotFoundException("Invalid username or password."));

	    // Map user_type to roles (authorities)
	    Set<String> userRoles = Collections.singleton(user.getUserType());

	    // Convert roles to a collection of GrantedAuthority objects
	    Set<GrantedAuthority> authorities = new HashSet<>();
	    for (String role : userRoles) {
	        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
	    }

	    return new org.springframework.security.core.userdetails.User(
	            user.getLibraryCardNumber(), // Use LibraryCardNumber as the username
	            user.getPassword(),
	            authorities);
	}
}
