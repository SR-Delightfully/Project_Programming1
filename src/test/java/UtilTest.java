import org.example.util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilTest {

    @Test
    public void testToTitleCase1() {
        String test = "french";
        String expectedResult = "French";
        String result = Util.toTitleCase(test);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testToTitleCase2() {
        String test = "programming 1";
        String expectedResult = "Programming 1";
        String result = Util.toTitleCase(test);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testToTitleCase3() {
        String test = "PrOgRaMmInG 1";
        String expectedResult = "Programming 1";
        String result = Util.toTitleCase(test);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testToTitleCase4() {
        String test = "intro to computer science";
        String expectedResult = "Intro To Computer Science";
        String result = Util.toTitleCase(test);

        Assertions.assertEquals(expectedResult, result);

    }
    @Test
    public void testToTitleCase5() {
        String test = "sabrina robinson";
        String expectedResult = "Sabrina Robinson";
        String result = Util.toTitleCase(test);

        Assertions.assertEquals(expectedResult, result);

    }

}
