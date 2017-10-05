/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafall2017test;

/**
 *
 * @author wmacevoy
 */
public class RelayDirective implements Directive {
    int gpio;
    boolean setting;
    
    public RelayDirective(int _gpio, boolean _setting) {
        gpio = _gpio;
        setting = _setting;
    }
    
    @Override
    public void action() {
        System.out.println("Set " + gpio + (setting? " on" : " off"));
    }
    
    @Override
    public String description() {
        return "set " + gpio + " pin to " + (setting ? "on" : "off");
    }

    @Override
    public int compareTo(Directive to) {
        if (to instanceof RelayDirective) {
            RelayDirective relay = (RelayDirective) to;
            if (gpio < relay.gpio) return  -1;
            if (gpio > relay.gpio) return   1;
            if (setting == false && relay.setting == true) return -1;
            if (setting == true  && relay.setting == false) return 1;
            return 0;
        } else {
            return this.getClass().getName().compareTo(to.getClass().getName());
        }
    }
    
    @Override 
    public boolean equals(Object o) {
        return compareTo((Directive) o) == 0;
    }
}
