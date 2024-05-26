package org.example;
import lombok.*;
import org.example.util.Util;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Setter
public class Department {
    // Field members:
    private String departmentId;
    private String departmentName;
    private static int nextId = 1 ;

    // All arguments constructor:
    public Department(String departmentId, String departmentName) {
        if (!validateDepartmentName(departmentName)) {
            this.departmentId = null;
            this.departmentName = null;
        } else {
            this.departmentId = getNextId();
            this.departmentName = Util.toTitleCase(departmentName);
        }
    }

    /**
     * provides a string containing the proceeding ID for the corresponding class.
     * @return a string that looks like "S001", "S002", "S003", etc.
     */
    public static String getNextId(){
        String num = Integer.toString(nextId);
        nextId++;
        return 'D' + num;
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

    /**
     * Checks whether a string contains a special character ( a character that is neither number nor letter).
     * @param input a string to be tested.
     * @return true is string contains a special character, false if not.
     */
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

    /**
     * Checks whether a string contains a digit ( a number ).
     * @param input a string to be tested.
     * @return true is string contains a number, false if not.
     */
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

    public String getDepartmentId() {
        return departmentId;
    }
    public String getDepartmentName() {
        return departmentName;
    }
}
