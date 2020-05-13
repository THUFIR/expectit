package expectit;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.logging.Logger;

public class Inf {

    private final static Logger log = Logger.getLogger(Inf.class.getName());

    public Inf() {
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
