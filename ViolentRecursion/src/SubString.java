import java.util.ArrayList;
import java.util.List;

public class SubString {
    // 不去重版本
    public List<String> findSubString1(String str) {
        List<String> result = new ArrayList<>();
        if (str == null || str.isEmpty()) {
            return result;
        }
        process(str, 0, result, "");
        return result;
    }

    private void process(String str, int index, List<String> result, String path) {
        if (index >= str.length()) {
            result.add(path);
            return;
        }

        process(str, index + 1, result, path);
        process(str, index + 1, result, path + str.charAt(index));
    }
}
