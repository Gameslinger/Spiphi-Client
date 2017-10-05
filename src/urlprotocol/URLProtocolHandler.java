/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urlprotocol;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/**
 *
 * @author Bennett.DenBleyker
 */
public class URLProtocolHandler extends URLStreamHandler {

    @Override
    protected URLConnection openConnection(URL url) {
        return new SpiphinURLConnection(url);
    }
}
