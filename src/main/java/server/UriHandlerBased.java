package server;

/**
 * Created with IntelliJ IDEA.
 * User: sergeyrybalkin
 * Date: 26.02.14
 * Time: 13:46
 * To change this template use File | Settings | File Templates.
 */

import io.netty.handler.codec.http.HttpRequest;

public abstract class UriHandlerBased {

    public abstract void process(HttpRequest request, StringBuilder buff);

    public String getContentType() {
        return "text/plain; charset=UTF-8";
    }
}
