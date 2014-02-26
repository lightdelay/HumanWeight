package server.handlers;

/**
 * Created with IntelliJ IDEA.
 * User: sergeyrybalkin
 * Date: 26.02.14
 * Time: 14:42
 * To change this template use File | Settings | File Templates.
 */

import io.netty.handler.codec.http.HttpRequest;
import logic.Logic;
import logic.Response;

import java.util.Map;

import static server.Util.getQueryMap;

@Mapped(uri = "/weight")
public class WeightHandler extends UriHandlerBased {

    @Override
    public void process(HttpRequest request, Logic logic, StringBuilder buff) {
        String result = "OK";

        try {
            String uri = request.getUri();
            String argsString = uri.substring(uri.indexOf("?") + 1);
            Map<String, String> args = getQueryMap(argsString);
            int firstArg = Integer.parseInt(args.get("level"));
            int secondArg = Integer.parseInt(args.get("index"));
            Response response = logic.getHumanEdgeWeight(firstArg, secondArg);
            if (response.getStatus() == 0) {
                result = String.valueOf(response.getValue());
            } else {
                result = "Bad request: response from logic module.";
            }
        } catch (NumberFormatException e) {
            result = "Bad arguments.";
        } catch (Exception e) {
            result = "Bad request.";
        }

        buff.append(result);
    }
}
