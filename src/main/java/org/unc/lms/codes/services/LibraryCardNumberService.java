package org.unc.lms.codes.services;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unc.lms.codes.repository.UserRepository;

@Service
public class LibraryCardNumberService {
	@Autowired
    private UserRepository userRepository;

    private Set<String> generatedNumbers = new HashSet<>();

    public String generateLibraryCardNumber() {
        while (true) {
            // Generate a random 14-digit number
            String randomNumber = generateRandomNumber(14);

            // Check if the generated number is unique in the database
            if (isUniqueInDatabase(randomNumber)) {
                generatedNumbers.add(randomNumber);
                return randomNumber;
            }
        }
    }

    private boolean isUniqueInDatabase(String number) {
        // Check if the generated number is unique in the database
        return !userRepository.existsByLibraryCardNumber(number);
    }

    private String generateRandomNumber(int length) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }
}     
