/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packets;

/**
 *
 * @author Bennett.DenBleyker
 */
public class Packet {

    public Packet(int type, char[] data) {

    }

    public static Packet parse(int type, char[] data) {
        return new EmptyPacket();
    }
    
    public static char[] serialize(Packet packet) {
        return new char[0];
    }
}
