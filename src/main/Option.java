/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Bennett.DenBleyker
 * @param <T>
 */
public class Option<T> {
    
    public static void options() {
        File f = new File("options");
        try {
            Scanner reader = new Scanner(new FileInputStream(f));
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String name = line.split(":")[0];
                String value = line.split(":")[1];
                Option o;
                switch (name) {
                    case "WL":
                        o = new Option<Boolean>("Whitelist", Boolean.valueOf(value));
                    case "I/U":
                        o = new Option<String>("IPorUN", value);
                    case "Ref":
                        o = new Option<Integer>("Refresh", Integer.valueOf(value));
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR 404: File \"options\" not found");
        }
    }
    
    String name;
    T value;
    
    public Option (String name, T value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
