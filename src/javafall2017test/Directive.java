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
public interface Directive extends Comparable < Directive > {
    public void action();
    public String description();
}
