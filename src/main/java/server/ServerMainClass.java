package server;

/**
 * Created with IntelliJ IDEA.
 * User: sergeyrybalkin
 * Date: 26.02.14
 * Time: 13:49
 * To change this template use File | Settings | File Templates.
 */
public class ServerMainClass {
    public static void main(String... args) {
        HttpServer server = new HttpServer(8080);
        System.out.println("Xui");
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
