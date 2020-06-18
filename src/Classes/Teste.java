package Classes;

import gnu.io.CommPortIdentifier;
import java.util.Enumeration;
import java.util.HashMap;

/**
 *
 * @author Lucas Santos
 */
public class Teste {

    public static void main(String[] args) {
        Enumeration pList = CommPortIdentifier.getPortIdentifiers();
        //HashMap map = new HashMap();
        while (pList.hasMoreElements()) {
            CommPortIdentifier cpi = (CommPortIdentifier) pList.nextElement();
            //map.put(cpi.getName(), cpi);
            if (cpi.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                System.out.println(cpi.getName());
            }
        }
    }
}
