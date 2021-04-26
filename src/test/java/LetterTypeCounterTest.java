import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LetterTypeCounterTest {
    LetterTypeCounter counter = new LetterTypeCounter();

    @Test
    void readPhraseFromFileBadInputFileName () {
        assertNull(counter.readPhraseFromFile("ThisIsAWrongFileName", 1));
    }

    @Test
    void readPhraseFromFileBadInputFileId () {
        assertNull(counter.readPhraseFromFile(".phrases.xml", 12)); // Da null porque no hay index 12
    }

    @Test
    void countVocalLettersRandomPhrase () {
        assertEquals(30, counter.countVocalLetters("Al que madruga, nadie le hace el desayuno porque es el primero en levantarse"));
    }

    @Test
    void countConsonantLettersRandomPhrase () {
        assertEquals(32, counter.countConsonantLetters("Al que madruga, nadie le hace el desayuno porque es el primero en levantarse"));
    }

    @Test
    void countVocalLettersOfNull () {
        assertNull(counter.countVocalLetters(null));
    }

    @Test
    void countConsonantLettersOfNull () {
        assertNull(counter.countConsonantLetters(null));
    }

    @Test
    void countVocalLettersOfEmptyString () {
        assertEquals(0, counter.countVocalLetters(""));
    }

    @Test
    void countConsonantLettersOfEmptyString () {
        assertEquals(0, counter.countConsonantLetters(""));
    }
}