/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chordtestclient;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.PropertyLoad;

/**
 *
 * @author Ashish
 */
public class Filesender implements Runnable {
    private File[] files;
    private String email;

    public Filesender(File inp,File jarf,String email) {
        files=new File[2];
        files[0]=inp;
        files[1]=jarf;
        this.email = email;
    }
    
    @Override
    public void run() {
        try{
            Socket socket = new Socket(PropertyLoad.getString("bootstrapperip"),
                PropertyLoad.getInteger("tasklistenport"));
        
                // File[] files = new File[2];
                // files[0]=new File("pagecounts");//Data set containing wikipedia dum
                // files[1]=new File("TaskTest.jar"); //Jar file containing map and reduce function

                System.out.println("Sending File");
                try{
                BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
                DataOutputStream dos = new DataOutputStream(bos);

                //dos.writeInt(files.length);

                for(File file : files)
                {
                      long length = file.length();
                      dos.writeLong(length);

                    // String name = file.getName();
                    // dos.writeUTF(name);

                    FileInputStream fis = new FileInputStream(file);
                    BufferedInputStream bis = new BufferedInputStream(fis);

                    int theByte = 0;
                    while((theByte = bis.read()) != -1) bos.write(theByte);

                    bis.close();
                   }

                dos.close();
                socket.close();
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                
                } catch (IOException ex) {
            Logger.getLogger(Filesender.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
    
}
