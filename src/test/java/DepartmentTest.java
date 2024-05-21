import org.example.Address;
import org.example.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DepartmentTest {

    @Test
    public void testValidateDepartmentName0() {
        String test = null;
        boolean expectedResult = false;
        boolean result = Department.validateDepartmentName(test);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testValidateDepartmentName1() {
        String test = "Anthropology";
        boolean expectedResult = true;
        boolean result = Department.validateDepartmentName(test);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testValidateDepartmentName2() {
        String test = "@nth&opo!ogy";
        boolean expectedResult = false;
        boolean result = Department.validateDepartmentName(test);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testValidateDepartmentName3() {
        String test = "4nthr0p010gy";
        boolean expectedResult = false;
        boolean result = Department.validateDepartmentName(test);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testValidateDepartmentName4() {
        String test = "Computer Science";
        boolean expectedResult = true;
        boolean result = Department.validateDepartmentName(test);

        Assertions.assertEquals(expectedResult, result);
    }
}
