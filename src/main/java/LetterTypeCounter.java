import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class LetterTypeCounter {

    private static final char[] VOCALS = "aeiouáéíóú".toCharArray();
    private static final char[] CONSONANTS = "bcdfghjklmnpqrstvwxyz".toCharArray();

    public static String readPhraseFromFile (String filename, int id) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(filename));

            NodeList list = doc.getElementsByTagName("phrases");
            Node node = list.item(id);

            if (node == null) {
                return null;
            }

            return node.getTextContent();

        } catch (ParserConfigurationException | SAXException | IOException e) {
        }
        return null;
    }

    public static Integer countVocalLetters (String _phrase) {
        if (_phrase == null) {
            return null;
        }

        char[] phrase = _phrase.toCharArray();
        Integer counter = 0;
        counter = compareWithCharArray(phrase, counter, VOCALS);
        return counter;
    }

    private static int compareWithCharArray (char[] phrase, int counter, char[] compareTo) {
        for (int i = 0; i < phrase.length; i++) {
            for (char letter : compareTo) {
                if (phrase[i] == letter || Character.toLowerCase(phrase[i]) == letter) {
                    counter++;
                    break;
                }
            }
        }
        return counter;
    }

    public static Integer countConsonantLetters (String _phrase) {
        if (_phrase == null) {
            return null;
        }

        char[] phrase = _phrase.toCharArray();
        Integer counter = 0;
        counter = compareWithCharArray(phrase, counter, CONSONANTS);
        return counter;
    }

}
