import java.util.Comparator;

public class Testing implements Comparator <String> {

    public int compare(String a, String b) {
        return -(a.length() - b.length());
    }
}
