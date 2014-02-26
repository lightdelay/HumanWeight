package server;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: sergeyrybalkin
 * Date: 26.02.14
 * Time: 15:00
 * To change this template use File | Settings | File Templates.
 */
public class Util {
    public static Map<String, String> getQueryMap(String query) {
        String[] params = query.split("&");
        Map<String, String> map = new HashMap<String, String>();
        for (String param : params) {
            String name = param.split("=")[0];
            String value = param.split("=")[1];
            map.put(name, value);
        }
        return map;
    }

    public static boolean isInRange(int target, int a, int b) {
        return target >= a && target <= b;
    }
}
