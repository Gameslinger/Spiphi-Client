/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import packets.Packet;
import packets.ping.PingPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Bennett.DenBleyker
 */
public class P2P extends ACommunication {

    public static void main(String[] args) {
//        try {
//            switch (args[0]) {
//                case "me":
//                    Main.p2p.connect(InetAddress.getLocalHost());
//                case "ip":
//                    Main.p2p.connect(InetAddress.getByName(args[1]));
//            }
//        } catch (UnknownHostException ex) {
//            ex.printStackTrace();
//        }
        P2P p2p = new P2P();
        System.out.println(p2p.connect(""));
    }

    final ScheduledExecutorService execService = Executors.newSingleThreadScheduledExecutor();

    Callable<Void> task = new Callable() {
        @Override
        public Class<Void> call() {
            refresh();
            return Void.TYPE;
        }
    };

    public P2P() {
//        try {
//            preStart();
//            task.call();
//        } catch (Exception ex) {
//
//        }
    }

    @Override
    public void refresh() {
        System.out.println("Hi");
        execService.schedule(task, ((Integer) getOption("Refresh").getValue()), TimeUnit.MINUTES);
    }

    @Override
    public void addFriend(InetAddress ip) {

    }

    @Override
    public void addFriend(String username) {

    }

    @Override
    public boolean createRequest() {
        return true;
    }

    @Override
    public boolean acceptRequest() {
        return true;
    }

    @Override
    public boolean denyRequest() {
        return true;
    }

    @Override
    public void start() {

    }

    @Override
    public void setup() {

    }

    @Override
    public boolean connect(String ip) {
        Packet ping = new PingPacket();
        return ACommunication.send(ping, ip);
    }

}
