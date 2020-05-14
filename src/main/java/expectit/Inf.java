package expectit;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.logging.Logger;

public class Inf {

    private final static Logger log = Logger.getLogger(Inf.class.getName());

    public Inf() {
    }

    public void bar() {
//Press Return to continue:
//Press Return for menu
//or enter 3 letter forecast city code-- 
//                 WEATHER UNDERGROUND MAIN MENU
//                         CITY FORECAST MENU
//        Enter 3-letter city code: nyc
//                    Press Return for menu: 
//                         CITY FORECAST MENU
//          Enter 3-letter city code: lax
//  Press Return for menu: 
//                         CITY FORECAST MENU
//          Enter 3-letter city code: chi
//   Press Return to continue, M to return to menu, X to exit: x




    
//nyc    
    

    //    expect.expect(contains("Press Return to continue"));
    //    expect.sendLine();
    //    expect.expect(contains("forecast city code--"));
    //    expect.sendLine("nyc");
    //    expect.expect(contains("X to exit:"));
    //    expect.sendLine("m");
    
    
//lax
    

    //    expect.expect(contains("Press Return to continue"));
    //    expect.sendLine();
    //    expect.expect(contains("forecast city code--"));
    //    expect.sendLine("lax");
    //    expect.expect(contains("X to exit:"));
    //    expect.sendLine("m");

//chi
    

    //    expect.expect(contains("Press Return to continue"));
    //    expect.sendLine();
    //    expect.expect(contains("forecast city code--"));
    //    expect.sendLine("chi");
    //    expect.expect(contains("X to exit:"));
    //    expect.sendLine("x");

    
    }

    public void foo() {
        Deque<String> cities = new ArrayDeque<>();
        cities.add("nyc");
        cities.add("lax");
        cities.add("chi");

        Iterator it = cities.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}
