package server;

/**
 * Created with IntelliJ IDEA.
 * User: sergeyrybalkin
 * Date: 26.02.14
 * Time: 13:47
 * To change this template use File | Settings | File Templates.
 */

import io.netty.handler.codec.http.HttpRequest;

@Mapped(uri = "/h1")
public class UriHandler1 extends UriHandlerBased {

    @Override
    public void process(HttpRequest request, StringBuilder buff) {
        buff.append("HELLO HANDLER1!");
    }
}
