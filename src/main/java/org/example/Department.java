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
        this.departmentId = departmentId;
        this.departmentName = (validateDepartmentName(departmentName)) ? departmentName: null;
        //Department.nextId = nextId;
        this.nextId = nextId;
    }

    public static boolean validateDepartmentName(String departmentName) {
        //TODO:
        // check if department name contains special characters
        // if departmentName contains special characters return false
        // else if departmentName contains only letters or spaces return true.
        return false;
    }
}
