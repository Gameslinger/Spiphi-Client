/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package URLProtocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Bennett.DenBleyker
 */
public class SpiphinURLConnection extends URLConnection {

    static int defaultPort = 4198;

    @Override
    public String getContentType() {
        return guessContentTypeFromName(url.getFile());
    }

    SpiphinURLConnection(URL url) {
        super(url);
    }

    @Override
    public void connect() throws IOException {
        String path = url.getPath().replaceFirst("/", "");
        switch (url.getHost()) {
            case "id":
                System.out.println("ID: " + path);
                break;
            case "user":
                System.out.println("User: " + path);
                break;
            case "ip":
                System.out.println("IP: " + path);
                break;
            case "me":
                System.out.println("Me");
                break;
            default:
                System.out.println("Main");
        }
        connected = true;
    }
    
    //spiphin://me accesses one's self
    //spiphin://id/874923 accesses a user with the id 874923
    
}
