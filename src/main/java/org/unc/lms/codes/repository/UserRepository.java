package org.unc.lms.codes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unc.lms.codes.model.data.User;
import org.unc.lms.codes.model.form.LibraryRegistrationForm;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, String>{

	 User findByStudentId(String studentId);
	 
	 User save(LibraryRegistrationForm libraryRegistrationForm);
	 
	 Optional<User> findByStudentIdAndPassword(String studentId, String password);
	 
	 User  findByLibraryCardNumberOrUsernameOrStudentId(String libraryCardNumber, String ezName, String studentId);
}
