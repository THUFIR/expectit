package expectit;

import java.util.logging.Logger;
import static net.sf.expectit.matcher.Matchers.contains;
import static net.sf.expectit.matcher.Matchers.eof;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class Triple {

    private final static Logger log = Logger.getLogger(Triple.class.getName());
    private Queue cities = new LinkedList();

    public Triple() {
        cities.add("nyc");
        cities.add("lax");
        cities.add("chi");
    }

    private void foo(net.sf.expectit.Expect expect, String city) throws IOException {
        expect.expect(contains("Press Return to continue"));
        expect.sendLine("m");

        expect.expect(contains("Selection:"));
        expect.sendLine("1");

        expect.expect(contains("Enter 3-letter city code:"));
        expect.sendLine(city.toUpperCase());
    }

    void telnet() throws IOException {

        Process process = Runtime.getRuntime().exec("telnet rainmaker.wunderground.com");

        StringBuilder wholeBuffer = new StringBuilder();
        net.sf.expectit.Expect expect = new net.sf.expectit.ExpectBuilder()
                .withOutput(process.getOutputStream())
                .withInputs(process.getInputStream())
                .withEchoOutput(wholeBuffer)
                .withEchoInput(wholeBuffer)
                .withExceptionOnFailure()
                .build();

        expect.expect(contains("Press Return to continue"));
        expect.sendLine();
        expect.expect(contains("forecast city code--"));
        expect.sendLine(cities.remove().toString());

        ////////////////
        //access via Iterator
        String city = null;
        Iterator<String> iterator = cities.iterator();
        while (iterator.hasNext())   {
            city = iterator.next().toString();
            foo(expect, city);
            foo(expect, city);
        }

        /////
        expect.expect(contains("Press Return to continue"));
        expect.sendLine("x");

        String response = wholeBuffer.toString();
        System.out.println(response);

        expect.close();

    }

}
