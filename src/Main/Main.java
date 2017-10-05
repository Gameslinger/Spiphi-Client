/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import URLProtocol.SpiphinURLConnection;
import URLProtocol.URLProtocolHandlerFactory;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Bennett.DenBleyker
 */
public class Main {

    public static P2P p2p;

    /**
     * @param args the command line arguments
     * @throws java.net.MalformedURLException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        if (args.length > 0) {
            String[] arg = args[0].split("/");
            String path = "";
            for (int i = 3; i < arg.length; i++) {
                path += arg[i] + "/";
            }
            switch (arg[2]) {
                case "id":
                    SpiphinURLConnection.output("ID: " + path.replaceFirst("/", ""));
                    break;
                case "user":
                    SpiphinURLConnection.output("User: " + path);
                    break;
                case "ip":
                    SpiphinURLConnection.output("IP: " + path.replaceFirst("/", ""));
                    break;
                case "me":
                    SpiphinURLConnection.output("Me");
                    break;
                default:
                    SpiphinURLConnection.output("Main: " + arg[0] + " | " + path);
            }
        } else {
            SpiphinURLConnection.output("Uh-oh");
            P2P.main(args);
        }
        //p2p = new P2P();
        //Option.options();
    }
}
