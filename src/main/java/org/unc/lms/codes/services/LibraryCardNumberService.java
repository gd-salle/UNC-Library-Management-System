package org.unc.lms.codes.services;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class LibraryCardNumberService {
	private Set<String> generatedNumbers = new HashSet<>();

    public String generateLibraryCardNumber() {
        while (true) {
            // Generate a random 14-digit number
            String randomNumber = generateRandomNumber(14);

            // Check if the generated number is unique
            if (isUnique(randomNumber)) {
                generatedNumbers.add(randomNumber);
                return randomNumber;
            }
        }
    }
 
    private boolean isUnique(String number) {
        return !generatedNumbers.contains(number);
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
