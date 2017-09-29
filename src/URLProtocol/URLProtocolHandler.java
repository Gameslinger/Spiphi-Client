/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package URLProtocol;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/**
 *
 * @author Bennett.DenBleyker
 */
public class URLProtocolHandler extends URLStreamHandler {
    
    @Override
    protected void parseURL(URL url, String spec,
                            int start, int end) {
        int slash = spec.indexOf('/'); 
        String crypType = spec.substring(start, slash-1); 
        super.parseURL(url, spec, slash, end); 
        setURL( url, "crypt:"+crypType, url.getHost( ),  
            url.getPort(), url.getFile(), url.getRef( ) ); 
    } 
 
    @Override
    protected URLConnection openConnection(URL url)
      throws IOException { 
        String crypType = url.getProtocol( ).substring(6); 
        return new SpiphinURLConnection( url, crypType ); 
    }
}
