import java.io.IOException;
import java.net.URI;

class StringServerAdder implements URLHandler {
    String stringsOnSite = "";

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return stringsOnSite;
        } else {
            //System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add-message")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("string")) {
                    return stringsOnSite += parameters[1] + "\n";
                }
            }
            return "404 Not Found! What the heck???";
        }
    }
}

class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Must put port number");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
