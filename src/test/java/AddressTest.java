import org.example.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressTest {

    @Test
    public void testIsPostalCodeValid0() {
        String test = null;
        boolean expectedResult = false;
        boolean result = Address.isPostalCodeValid(test);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsPostalCodeValid1() {
        String test = "H4E3G";
        boolean expectedResult = false;
        boolean result = Address.isPostalCodeValid(test);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsPostalCodeValid2() {
        String test = "H4E3G3";
        boolean expectedResult = true;
        boolean result = Address.isPostalCodeValid(test);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsPostalCodeValid3() {
        String test = "4E3G3H";
        boolean expectedResult = false;
        boolean result = Address.isPostalCodeValid(test);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsPostalCodeValid4() {
        String test = "!4$3&3";
        boolean expectedResult = false;
        boolean result = Address.isPostalCodeValid(test);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsPostalCodeValid5() {
        String test = "H E 3 3";
        boolean expectedResult = false;
        boolean result = Address.isPostalCodeValid(test);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsPostalCodeValid6() {
        String test = "H4E 3G3";
        boolean expectedResult = true;
        boolean result = Address.isPostalCodeValid(test);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsPostalCodeValid7() {
        String test = "4E3 G3H";
        boolean expectedResult = false;
        boolean result = Address.isPostalCodeValid(test);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsPostalCodeValid8() {
        String test = "!4$ 3&3";
        boolean expectedResult = false;
        boolean result = Address.isPostalCodeValid(test);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsPostalCodeValid9() {
        String test = "H3E3G3H";
        boolean expectedResult = false;
        boolean result = Address.isPostalCodeValid(test);

        Assertions.assertEquals(expectedResult, result);
    }
}
