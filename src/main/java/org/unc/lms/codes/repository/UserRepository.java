package org.unc.lms.codes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unc.lms.codes.model.data.User;
import org.unc.lms.codes.model.form.LibraryRegistrationForm;


@Repository
public interface UserRepository extends JpaRepository<User, String>{

//	 User findByStudentId(String studentId);
//	 User findByLibraryCardNumber(String libraryCardNumber);
	 
	 User save(LibraryRegistrationForm libraryRegistrationForm);
	 
//	 Optional<User> findByStudentIdAndPassword(String studentId, String password);
	 Optional<User> findByLibraryCardNumberAndPassword(String libraryCardNumber, String password);

	 Optional<User> findByLibraryCardNumber(String libraryCardNumber);
	 boolean existsByLibraryCardNumber(String libraryCardNumber);
}
