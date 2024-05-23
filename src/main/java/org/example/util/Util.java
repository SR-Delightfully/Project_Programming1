package org.example.util;

public class Util {
    /**
     * Takes a string as an input, looks for spaces and capitalizes the character found immediately afterward.
     * @param strIn represents the name that will be converted to title case.
     * @return returns a string with each word starting with a capital letter.
     */
    public static String toTitleCase(String strIn) {
        String[] splitStr = new String[strIn.length()];
        String titleCaseStr = "";

        if (strIn == null) {
            return "ERROR: Please provide a name";
        }

        for (int i=0; i < strIn.length(); i++) {
            splitStr[i] = strIn.substring(i, i+1).toLowerCase();
            if (i == 0 || strIn.charAt(i - 1) == ' '){
                splitStr[i] = strIn.substring(i, i+1).toUpperCase();
            }
            titleCaseStr += splitStr[i];
        }

        return titleCaseStr;
    }
}
