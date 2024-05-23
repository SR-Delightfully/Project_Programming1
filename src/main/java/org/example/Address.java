package org.example;
import lombok.*;

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
        boolean ans = false;

        if (postalCode == null) {
            return false;
        }
        if (hasSpecialChara(postalCode)) {
            return false;
        }

        if ( postalCode.length() < 6 || postalCode.length() >= 8) {
            return false;
        }

        if (postalCode.length() == 6) {
            for (int i=0; i < postalCode.length(); i++) {
                char currentPosition = postalCode.charAt(i);
                switch (i) {
                    case 0,2,4 : // should be a character
                        ans = Character.isLetter(currentPosition);
                    case 1,3,5 : // should be a digit
                        ans = Character.isDigit(currentPosition);
                }
            }
        }

        if (postalCode.length() == 7) {
            int spaceCounter = 0;
            for (int i=0; i < postalCode.length(); i++) {
                char currentPosition = postalCode.charAt(i);
                if (currentPosition == ' ') {
                    spaceCounter += 1;
                }
                if (spaceCounter >= 2) {
                    return false;
                }
                switch (i) {
                    case 0,2,5 :
                        ans = Character.isLetter(currentPosition);
                    case 1,4,6 :
                        ans = Character.isDigit(currentPosition);
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
}
