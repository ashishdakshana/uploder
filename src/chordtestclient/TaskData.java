/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chordtestclient;

import java.io.File;

/**
 *
 * @author Ashish
 */
public class TaskData implements java.io.Serializable  {
    public String input;
    public byte[] jarfile;
    
    
    TaskData()
    {
        
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void setJarfile(byte[] jarfile) {
        this.jarfile = jarfile;
    }
          
}
