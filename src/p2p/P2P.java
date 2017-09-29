/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2p;

import java.net.InetAddress;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Bennett.DenBleyker
 */
public class P2P extends IP2P {

    public static P2P p2p;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        p2p = new P2P();
        Option.options();
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
        try {
            preStart();
            task.call();
        } catch (Exception ex) {

        }
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

}
