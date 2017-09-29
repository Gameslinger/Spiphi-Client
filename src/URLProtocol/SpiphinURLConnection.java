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

    static int defaultPort = 80;
    SpiphinInputStream cis;

    public String getContentType() {
        return guessContentTypeFromName(url.getFile());
    }

    SpiphinURLConnection(URL url, String crypType)
            throws IOException {
        super(url);
        try {
            String classname = "learningjava.protocolhandlers.crypt."
                    + crypType + "SpiphinInputStream";
            cis = (SpiphinInputStream) Class.forName(classname).newInstance();
        } catch (Exception e) {
            throw new IOException("Spiphin Class Not Found: " + e);
        }
    }

    public void connect() throws IOException {
        int port = (url.getPort() == -1)
                ? defaultPort : url.getPort();
        Socket s = new Socket(url.getHost(), port);

        // Send the filename in plaintext 
        OutputStream server = s.getOutputStream();
        new PrintWriter(new OutputStreamWriter(server, "8859_1"),
                true).println("GET " + url.getFile());

        // Initialize the SpiphinInputStream 
        cis.set(s.getInputStream(), server);
        connected = true;
    }

    public InputStream getInputStream() throws IOException {
        if (!connected) {
            connect();
        }
        return (cis);
    }
    //spiphin://me accesses one's self
    //spiphin://id/874923 accesses a user with the id 874923
}
