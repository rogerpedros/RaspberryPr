package client;

import api.Api;
import api.Data;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Roger
 */
public class ClientAsincron extends Thread {
    public ClientAsincron(){}
    
    private static final String HOST = "192.168.1.3"; //localhost
    private static final int PORT = 1080;
    private static Registry registre;
    
    int nEstatLDR;
    int nEstatBoto;
    
    @Override
    public void run(){  
        while(true){
            System.out.println("FIL SINCRON PER LDR O BOTO");
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ClientAsincron.class.getName()).log(Level.SEVERE, null, ex);
            }
       
            try {
                nEstatLDR = LlegirLDR();
            } catch (Exception ex) {
                Logger.getLogger(ClientAsincron.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                nEstatBoto = LlegirBoto();
            } catch (Exception ex) {
                Logger.getLogger(ClientAsincron.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }  
    }
    
    public int LlegirLDR() throws Exception{
        registre = LocateRegistry.getRegistry(HOST, PORT);
        Api remoteApi = (Api) registre.lookup(Api.class.getSimpleName());
        
        int returnedData = (remoteApi.LlegirLDR(new Data(1)).getValor());
        System.out.println("EncendrePito:" + returnedData);
        
        return returnedData;
    }
     
    public int LlegirBoto() throws Exception{
        registre = LocateRegistry.getRegistry(HOST, PORT);
        Api remoteApi = (Api) registre.lookup(Api.class.getSimpleName());
        
        int returnedData = (remoteApi.LlegirBoto(new Data(1)).getValor());
        System.out.println("ApagarPito:" + returnedData);
    
        return returnedData;
    }
}
