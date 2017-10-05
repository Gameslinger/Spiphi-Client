/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import packets.Packet;

/**
 *
 * @author Bennett.DenBleyker
 */
public abstract class ACommunication {

    public static boolean send(Packet packet, String ip) {
        try {
            Socket socket = new Socket("localhost",4198);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.write(Packet.serialize(packet));
            out.flush();
            Packet inPacket = Packet.parse(input);
            System.out.println("Recieved Packet: "+inPacket);
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
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

    public abstract boolean connect(String ip);
}
