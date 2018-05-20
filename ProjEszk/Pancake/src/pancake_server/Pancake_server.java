package pancake_server;

import java.net.URL;
import java.net.URLClassLoader;

public class Pancake_server {

    public static void main(String[] args) {
        
        ClassLoader cl = ClassLoader.getSystemClassLoader();

        URL[] urls = ((URLClassLoader)cl).getURLs();

        for(URL url: urls){
        	System.out.println(url.getFile());
        }
        
        
        
        Server.ServerStarter.main(args);
    }
    
}
