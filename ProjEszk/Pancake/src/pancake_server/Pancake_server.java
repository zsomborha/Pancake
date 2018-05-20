package pancake_server;

import java.net.URL;
import java.net.URLClassLoader;

public class Pancake_server {

    public static void main(String[] args) {
        
        ClassLoader cl = ClassLoader.getSystemClassLoader();

        URL[] urls = ((URLClassLoader)cl).getURLs();

        System.out.println("Dependencies: ");
        
        for(URL url: urls){
        	System.out.println("Dependency= " + url.getFile());
        }
        
        
        
        Server.ServerStarter.main(args);
    }
    
}
