import java.time.LocalDate;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

/**
 * Utilitário JSON SUPER ENXUTO, suficiente para:
 * - Ler campos string/int/double simples;
 * - Ler arrays de strings;
 * - Ler nested ("rating":{"average":...}, "network":{"name":...});
 * - Ler arrays de inteiros para persistência.
 * NÃO é um parser JSON completo; serve ao escopo deste trabalho.
 */
public class JsonUtils {

    public static String quote(String s) {
        if (s == null) return "null";
        return "\"" + s.replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
    }

    public static String intSetToJson(Set<Integer> set) {
        return set.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
    }

    public static LocalDate toLocalDate(String s) {
        try {
            return (s == null || s.isBlank() || s.equals("null")) ? null : LocalDate.parse(s);
        } catch (Exception e) {
            return null;
        }
    }

    public static Integer getInt(String json, String key) {
        // "id": 123,
        Pattern p = Pattern.compile(Pattern.quote(key) + "\\s*:\\s*(\\d+)");
        Matcher m = p.matcher(json);
        return m.find() ? Integer.parseInt(m.group(1)) : null;
        }

    public static Double getDouble(String json, String key) {
        // "average": 7.5
        Pattern p = Pattern.compile(Pattern.quote(key) + "\\s*:\\s*(-?\\d+(?:\\.\\d+)?)");
        Matcher m = p.matcher(json);
        return m.find() ? Double.parseDouble(m.group(1)) : null;
    }

    public static String getString(String json, String key) {
        // "name": "XYZ"
        Pattern p = Pattern.compile(Pattern.quote(key) + "\\s*:\\s*\"(.*?)\"", Pattern.DOTALL);
        Matcher m = p.matcher(json);
        return m.find() ? unescape(m.group(1)) : null;
    }

    public static Double getNestedDouble(String json, String parentKey, String childKey) {
        String obj = getObject(json, parentKey);
        return (obj == null) ? null : getDouble(obj, childKey);
    }

    public static String getNestedString(String json, String parentKey, String childKey) {
        String obj = getObject(json, parentKey);
        return (obj == null) ? null : getString(obj, childKey);
    }

    public static String getObject(String json, String key) {
        // key: "{"
        Pattern p = Pattern.compile(Pattern.quote(key) + "\\s*:\\s*\\{");
        Matcher m = p.matcher(json);
        if (!m.find()) return null;
        int start = m.end() - 1; // aponta no '{'
        int end = findMatchingBrace(json, start);
        return (end > start) ? json.substring(start, end + 1) : null;
    }

    public static List<String> getStringArray(String json, String key) {
        // "genres": ["Drama","Crime"]
        String arr = getArray(json, key);
        if (arr == null) return List.of();
        List<String> out = new ArrayList<>();
        Pattern p = Pattern.compile("\"(.*?)\"");
        Matcher m = p.matcher(arr);
        while (m.find()) out.add(unescape(m.group(1)));
        return out;
    }

    public static Set<Integer> getIntSet(String json, String key) {
        String arr = getArray(json, key);
        if (arr == null) return new LinkedHashSet<>();
        LinkedHashSet<Integer> out = new LinkedHashSet<>();
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(arr);
        while (m.find()) out.add(Integer.parseInt(m.group()));
        return out;
    }

    public static String getArray(String json, String key) {
        Pattern p = Pattern.compile(Pattern.quote(key) + "\\s*:\\s*\\[");
        Matcher m = p.matcher(json);
        if (!m.find()) return null;
        int start = m.end() - 1; // '['
        int end = findMatchingBracket(json, start);
        return (end > start) ? json.substring(start, end + 1) : null;
    }

    public static List<String> extractObjects(String json, String prefixRegex, char closingBrace) {
        // extrai objetos que começam com o padrão (ex: "\"show\":\\s*\\{") e fecham com '}'
        Pattern p = Pattern.compile(prefixRegex);
        Matcher m = p.matcher(json);
        List<String> out = new ArrayList<>();
        while (m.find()) {
            int start = json.indexOf('{', m.end() - 1);
            if (start < 0) continue;
            int end = findMatchingBrace(json, start);
            if (end > start) out.add(json.substring(start, end + 1));
        }
        return out;
    }

    // ---------- helpers ----------
    private static int findMatchingBrace(String s, int openIdx) {
        int level = 0;
        for (int i = openIdx; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{') level++;
            else if (c == '}') { level--; if (level == 0) return i; }
        }
        return -1;
    }
    private static int findMatchingBracket(String s, int openIdx) {
        int level = 0;
        for (int i = openIdx; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') level++;
            else if (c == ']') { level--; if (level == 0) return i; }
        }
        return -1;
    }
    private static String unescape(String s) {
        return s.replace("\\\"", "\"").replace("\\\\", "\\");
    }
}
