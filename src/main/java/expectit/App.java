package expectit;

import java.util.logging.Logger;
import static net.sf.expectit.matcher.Matchers.contains;
import static net.sf.expectit.matcher.Matchers.eof;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class App {

    private final static Logger log = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws IOException {
      //  new App().telnet();
      Inf i = new Inf();
      i.foo();
    }

    private void telnet() throws IOException {
      
        
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
        expect.sendLine("nyc");
        expect.expect(contains("X to exit:"));
        expect.sendLine();

        String response = wholeBuffer.toString();
        System.out.println(response);

        expect.close();

    }

}
