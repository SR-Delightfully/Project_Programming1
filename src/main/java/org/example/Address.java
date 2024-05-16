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
       this.streetNo = streetNo;
       this.street = street;
       this.city = city;
       this.province = province;
       this.postalCode = (isPostalCodeValid(postalCode)) ? postalCode : null;
       this.country = country;
    }

    public static boolean isPostalCodeValid(String postalCode) {
        //TODO:
        // If length is 6, then it must follow the format 'CDCDCD'
        // if length is 7, then it must follow the format 'CDC DCD'
        // where 'C' refers to a character, and 'D' refers to a digit.
        // The method should be case-insensitive.
        return false;
    }
}
