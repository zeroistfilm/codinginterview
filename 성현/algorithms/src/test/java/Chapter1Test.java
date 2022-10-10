import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Chapter1Test {

    Chapter1 chapter1 = new Chapter1();

    @Test
    void duplicateCharacters() {
        var str = "aa";
        var hasDuplicates = chapter1.checkDuplicateChar(str);

        Assertions.assertEquals(true, hasDuplicates);
    }
}
