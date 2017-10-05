/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.net.InetAddress;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import packets.Packet;
import packets.iplookup.IpLookupPacket;

/**
 *
 * @author Gabriel.Maxfield, Bennett.DenBleyker
 */
public class P2P extends ACommunication {

    public static void main() {
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
        Packet ping = new IpLookupPacket(1234);
        return ACommunication.send(ping, ip);
    }

}
