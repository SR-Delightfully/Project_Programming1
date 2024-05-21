package org.example;
import lombok.*;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Department {
    // Field members:
    private String departmentId;
    private String departmentName;
    private static int nextId;

    // All arguments constructor:
    public Department(String departmentId, String departmentName, int nextId) {
        if (!validateDepartmentName(departmentName)) {
            this.departmentId = null;
            this.departmentName = null;
            this.nextId = 0;
        } else {
            this.departmentId = departmentId;
            this.departmentName = departmentName;
            this.nextId = nextId;
        }
    }

    public static boolean validateDepartmentName(String departmentName) {
        boolean ans = true;
        if ( departmentName == null ) {
            return false;
        }
        if (hasSpecialChara(departmentName)){
            ans = false;
        }
        if (hasDigits(departmentName)) {
            ans = false;
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

    public static boolean hasDigits(String input) {
        int[] digits = {1,2,3,4,5,6,7,8,9,0};
        boolean ans = false;

        for (int i=0; i < input.length(); i++) {
            for (int j=0; j < digits.length; j++) {
                if (Character.getNumericValue(input.charAt(i)) != digits[j]) {
                    j++;
                } else if (Character.getNumericValue(input.charAt(i)) == digits[j]) {
                    ans = true;
                }
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
