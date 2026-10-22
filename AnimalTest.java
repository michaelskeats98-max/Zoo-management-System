import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    @Test
    public void testLionMakeSound() {

        Lioncopy lion = new Lioncopy("Leo", 5, "Golden", 190.5, 25.0);

        String expected = "ROAR, my name isLeo, a5 year old Lion";
        String actual = lion.makeSound();

        assertEquals(expected, actual);
    }

    @Test
    public void testLionGetType() {
        Lioncopy lion = new Lioncopy("Leo", 5, "Golden", 190.5, 25.0);

        String expected = "Lioncopy";
        String actual = lion.getType();

        assertEquals(expected, actual);
    }

    @Test
    public void testSetAgeRejectsNegativeValue() {
        Lioncopy lion = new Lioncopy("Leo", 5, "Golden", 190.5, 25.0);

        lion.setAge(-3);

        assertEquals(5, lion.getAge());
    }
}
