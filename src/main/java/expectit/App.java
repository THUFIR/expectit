package expectit;

import java.util.logging.Logger;
import static net.sf.expectit.matcher.Matchers.contains;
import static net.sf.expectit.matcher.Matchers.eof;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class App {

    private final static Logger log = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws IOException {
        new App().telnet();
    }

    private void telnet() throws IOException {
        log.info("foo");

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
        expect.sendLine("SAN");
        expect.expect(contains("X to exit:"));
        expect.sendLine();

        String response = wholeBuffer.toString();
        System.out.println(response);

        expect.close();

    }

}
