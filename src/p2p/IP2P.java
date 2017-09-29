/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2p;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bennett.DenBleyker
 */
public abstract class IP2P {

    List<Option> options = new ArrayList();

    public abstract void refresh();

    public abstract void addFriend(InetAddress ip);

    public abstract void addFriend(String username);

    public abstract boolean createRequest();

    public abstract boolean acceptRequest();

    public abstract boolean denyRequest();

    public void preStart() throws IOException {
        File f = new File("options");
        if (!f.exists()) {
            f.createNewFile();
            setup();
        }
        start();
    }

    public abstract void start();

    public abstract void setup();

    public Option getOption(String name) {
        for (Option o : options) {
            if (o.name.equals(name));
            return o;
        }
        return null;
    }
}
