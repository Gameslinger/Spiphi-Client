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
public class PingPacket extends Packet {
    
    public PingPacket() {
        super(1, new char[] {1});
    }
    
}
