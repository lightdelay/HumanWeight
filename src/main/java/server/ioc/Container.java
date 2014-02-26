package server.ioc;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: sergeyrybalkin
 * Date: 26.02.14
 * Time: 16:35
 * To change this template use File | Settings | File Templates.
 */
public class Container {
    private Map<String, Integer> args;
    private String response;
    private java.util.Date date = null;

    public String toString() {
        return args +
                ":" + response + ":" + date;
    }
}
