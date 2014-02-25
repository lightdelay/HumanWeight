/**
 * Created with IntelliJ IDEA.
 * User: sergeyrybalkin
 * Date: 25.02.14
 * Time: 23:23
 * To change this template use File | Settings | File Templates.
 */
public class Response {
    private int status;
    private int value;

    public Response(int status, int value) {
        this.status = status;
        this.value = value;
    }

    public int getStatus() {
        return status;
    }

    public int getValue() {
        return value;
    }
}
