/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chordtestclient;
import de.uniba.wiai.lspi.chord.data.URL;
import de.uniba.wiai.lspi.chord.service.*;
import java.net.MalformedURLException;
//import de.uniba.wiai.lspi.chord.com;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utility.PropertyLoad;



/**
 *
 * @author Ashish
 */
public class Chordtest extends Application {

    /**
     * @param args the command line arguments
     */public static File file=null;
       public static Chord chord=null;
       
       public static Socket clientsocket=null;

    public static boolean initpeer() throws MalformedURLException, UnknownHostException
    {  try{
        de.uniba.wiai.lspi.chord.service.PropertiesLoader.loadPropertyFile();
        String bootip=PropertyLoad.getString("bootstrapperip");
        String peerip=PropertyLoad.getString("peerip");
        int bootsport=PropertyLoad.getInteger("bootstrapperport");
        int peerport=PropertyLoad.getInteger("peerport");
        
       
        chord=new de.uniba.wiai.lspi.chord.service.impl.ChordImpl();
        chord.join(new URL ( "ocsocket" + "://"+peerip+":"+peerport+"/"),
                new URL ( "ocsocket" + "://"+bootip+":"+bootsport+"/"));
        }
        catch(Exception e)
        {
            System.out.println("Error in peer initalization "+ e);
            return false;
        }
        return true;
    }
    
    
    /*
    public static boolean sendfiles() throws Exception //Send files to server for executing application
    {
        
                Socket socket = new Socket(PropertyLoad.getString("bootstrapperip"),
                PropertyLoad.getInteger("tasklistenport"));
        
                // File[] files = new File[2];
                 files[0]=new File("pagecounts");//Data set containing wikipedia dum
                 files[1]=new File("TaskTest.jar"); //Jar file containing map and reduce function

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
                
                return true;
                
    }
    */
    
  
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }  
    public static void main(String[] args)throws Exception{
        // TODO code application logic here
        cleanup();
        //System.out.println(SystemInfo.Info());
        //CpuUsage.printUsage();           
       // initpeer();
        //sendfiles();
        launch(args);
               
        
       // senddata("H:\\hadoophh\\hadoop-2.6.3\\LICENSE.txt");
        //senddata("H:\\hadoophh\\hadoop-2.6.3\\share\\hadoop\\hdfs\\hadoop-hdfs-2.6.3.jar");
        //clientsocket.close();
        
        /*
        Key key=new de.uniba.wiai.lspi.chord.console.command.entry.Key("mykey");
        Value v= new de.uniba.wiai.lspi.chord.console.command.entry.Value("uieo");
        //chord.insert(key, v);
//        RingFile rf=new RingFile();
        
        chord.insert(key, new RingFile("as","as".getBytes()));
        chord.insert(key, new RingFile("ad","ad".getBytes()));
        
        Set<Serializable> vs=chord.retrieve(key);
       
        Object[] values = vs.toArray(new Object[vs.size()]);
        
        System.out.println(((RingFile)values[0]).filebytes);
        System.out.println(((RingFile)values[1]).filebytes);
        //System.out.println(values[1]);
        System.out.println(vs.size());
        */
        
    
}
    public static void cleanup()
    {File chorddata=new File("chorddata");
    if(chorddata.exists())
        chorddata.delete();
        
    }
    
    
    
}
