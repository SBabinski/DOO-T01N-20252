import java.util.*;
import org.json.JSONArray;

public class Utils {
    public static List<String> jsonArrayToListOfStrings(JSONArray arr) {
        List<String> saida = new ArrayList<>();
        if (arr == null) return saida;
        for (int i = 0; i < arr.length(); i++) saida.add(arr.optString(i));
        return saida;
    }
}
