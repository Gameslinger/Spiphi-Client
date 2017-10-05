/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urlprotocol;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                output("ID: " + path);
                break;
            case "user":
                output("User: " + path);
                break;
            case "ip":
                output("IP: " + path);
                break;
            case "me":
                output("Me");
                break;
            default:
                output("Main: " + path);
        }
        connected = true;
    }
    
    public static void output(String out) {
        File user = new File("user.txt");
        String username = "benne";
        try {
            Scanner s = new Scanner (new FileInputStream(user));
            username = s.next();
        } catch (Exception ex) {
            
        }
        File f = new File("C:\\Users\\" + username + "\\Documents\\o.txt");
        FileOutputStream fos;
        try {
            f.createNewFile();
            fos = new FileOutputStream(f);
            fos.write(out.getBytes());
            fos.close();
            Thread.sleep(10000);
        } catch (Exception ex) {
            
        }
    }
    
    //spiphin://me accesses one's self
    //spiphin://id/874923 accesses a user with the id 874923
    
}
