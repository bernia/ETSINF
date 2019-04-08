package practica1;


/**
 * class WrapperClassesUse.
 * 
 * @author LTP 
 * @version 2017-18
 */

public class WrapperClassesUse {        
    public static void main(String[] args) {            
		// Assignment of wrapper variables to elementary types 
        int i = new Integer(123456);		
		byte b = new Byte((byte) 10);
		short s = new Short((short) 25);
		long l = new Long(26451);
		boolean bol = new Boolean(true);
		float f = new Float(12345678f);
		double d = new Double(5115.156);
		char c = new Character('A');
            
        // Writing elementary variables
		System.out.println("int i = " + i);
        System.out.println("byte b = " + b);
        System.out.println("short s = " + s);
        System.out.println("long l = " + l);
        System.out.println("boolean bol = " + bol);
        System.out.println("float f = " + f);
        System.out.println("double d = " + d);
        System.out.println("char c = " + c);
      
		// Assignment of elementary values to wrapper variables
		Integer eI = 123456; 
        Byte eB = 10;
        Short eS = 25;
        Long eL = 12345l;
        Boolean eBol = false;
        Float eF = 12345678f;
        Double eD = 1541.15;
        Character eC = 'x';
       
        // Writing wrapper variables
		System.out.println("Integer I = " + eI);
        System.out.println("Byte B = " + eB);
        System.out.println("Short S = " + eS);
        System.out.println("Long L = " + eL);
        System.out.println("Boolean Bol = " + eBol);
        System.out.println("Float F = " + eF);
        System.out.println("Double D = " + eD);
        System.out.println("Character C = " + eC);
    }    
}