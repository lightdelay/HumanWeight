package server.handlers;

/**
 * Created with IntelliJ IDEA.
 * User: sergeyrybalkin
 * Date: 26.02.14
 * Time: 14:42
 * To change this template use File | Settings | File Templates.
 */

import io.netty.handler.codec.http.HttpRequest;
import logic.Response;
import logic.WeightService;

import java.util.Map;

import static server.Util.getQueryMap;

@Mapped(uri = "/weight")
public class WeightHandler extends UriHandlerBased {

    @Override
    public void process(HttpRequest request, WeightService weightService, StringBuilder buff) {
        String result = "OK";
        String firstRequestRegExp = "^/(.+)?(.+)&(.+)$";
        String secondRequestRegExp = "^/(.+)/([0-9]+)/([0-9]+)$";

        try {
            String uri = request.getUri();
            int firstArg = -1;
            int secondArg = -1;
            Response response = null;
            if (uri.matches(firstRequestRegExp)) {
                String argsString = uri.substring(uri.indexOf("?") + 1);
                Map<String, String> args = getQueryMap(argsString);
                firstArg = Integer.parseInt(args.get("level"));
                secondArg = Integer.parseInt(args.get("index"));
                response = weightService.getHumanEdgeWeight(firstArg, secondArg);
            } else if (uri.matches(secondRequestRegExp)) {
                String[] fields = uri.split("/");
                firstArg = Integer.valueOf(fields[2]);
                secondArg = Integer.valueOf(fields[3]);
                response = weightService.getHumanEdgeWeight(firstArg, secondArg);
            } else {
                buff.append("Bad request.");
                return;
            }

            if (response.getStatus() == 0) {
                buff.append(String.valueOf(response.getValue()));
            } else {
                buff.append("Bad request: response from weightService.");
            }
        } catch (NumberFormatException e) {
            buff.append("Bad arguments.");
        } catch (Exception e) {
            buff.append("Bad request.");
        }
    }
}
