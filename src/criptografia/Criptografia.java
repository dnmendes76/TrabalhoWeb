package criptografia;

import org.apache.commons.codec.binary.*;

public class Criptografia {
	
	//Codifica
    public static String codifica(String msg) {
        return new Base64().encodeToString(msg.getBytes());
    }
 
    // Decodifica
    public static String decodifica(String msg) {
        return new String(new Base64().decode(msg));
    }

}
