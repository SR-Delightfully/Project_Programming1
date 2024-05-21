package org.example;
import lombok.*;

import java.time.chrono.IsoEra;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Address {
    // Field members:
    private int streetNo;
    private String street;
    private String city;
    private String province;
    private String postalCode;
    private String country;

    // All arguments constructor:
    public Address(int streetNo, String street, String city, String province, String postalCode, String country) {

        if (isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode;
            this.country = country;
        } else {
            this.streetNo = 0;
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
            this.country = null;
        }
    }

    public static boolean isPostalCodeValid(String postalCode) {
        //TODO:
        // If length is 6, then it must follow the format 'CDCDCD'
        // if length is 7, then it must follow the format 'CDC DCD'
        // where 'C' refers to a character, and 'D' refers to a digit.
        // The method should be case-insensitive.

        boolean ans = true;
        if (postalCode == null) {
            return false;
        }
        // check length of string, if not in range of [6,7] return false.
        if ( postalCode.length() < 6 || postalCode.length() >= 8) {
            return false;
        }

        // check if string contains special character, if it does return false.
        if (hasSpecialChara(postalCode)){
            return false;
        }

        // if string has a length of 6, return false if it contains spaces
        if (postalCode.length() == 6) {
            if (hasSpaces(postalCode)) {
                return false;
            }
            if (!hasSpaces(postalCode)) {
                // if string with length of 6 does not have any spaces, check format of string
                for (int i=0; i<postalCode.length(); i++) {
                    if (i % 2 == 0 && !isLetter(postalCode.charAt(i))) {
                        ans = false;
                    } else {
                        ans = true;
                    }
                    if (i % 3 == 0 && !isDigit(postalCode.charAt(i))) {
                        ans = false;
                    } else {
                        ans = true;
                    }
                }
            }
        }
        return ans;
    }

    public static boolean hasSpecialChara(String input) {
        char[] specialCharacters = {'!','@','#','$','%','^','&','*','-','_','+','/'};
        boolean ans = false;

        for (int i=0; i < input.length(); i++) {
            for (int j=0; j < specialCharacters.length; j++) {
                if (input.charAt(i) != specialCharacters[j]) {
                    j++;
                } else if (input.charAt(i) == specialCharacters[j]) {
                    ans = true;
                }
            }
        }

        return ans;
    }
    public static boolean isLetter(char input) {
        char[] characters = {
                'a','b','c','d','e','f','g','h','i','j','k','l',
                'm','n','o','p','q','r','s','t','u','v','w','x','y','z'
        };
        boolean ans = true;

        for (int j=0; j < characters.length; j++) {
            if (input != characters[j]) {
                j++;
            } else {
                ans = false;
            }
        }

        return ans;
    }

    public static boolean isDigit(char input) {
        int[] digits = {1,2,3,4,5,6,7,8,9,0};
        boolean ans = true;

        for (int i=0; i < digits.length; i++) {
            if (Character.getNumericValue(input) != digits[i]) {
                i++;
            } else {
                ans = false;
            }
        }

        return ans;
    }

    public static boolean hasSpaces(String input) {
        boolean ans = false;

        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) == ' ') {
                ans = true;
            }
        }

        return ans;
    }
}
