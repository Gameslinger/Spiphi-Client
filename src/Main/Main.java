/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

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
        URL.setURLStreamHandlerFactory(new URLProtocolHandlerFactory());
        URLConnection connection = new URL("").openConnection();
        connection.connect();
        //p2p = new P2P();
        //Option.options();
    }
}
