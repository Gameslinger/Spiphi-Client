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
public class PingResponsePacket extends Packet {
    
    public PingResponsePacket() {
        super(2, new char[] {1});
    }
    
}
