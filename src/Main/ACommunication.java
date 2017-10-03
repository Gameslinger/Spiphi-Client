/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Packets.Packet;
import java.io.File;
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
public abstract class ACommunication {

    public static boolean send(Packet packet, InetAddress ip) {
        try {
            return ip.isReachable(1000);
        } catch (IOException ex) {
            Logger.getLogger(ACommunication.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

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

    public abstract boolean connect(InetAddress ip);
}
