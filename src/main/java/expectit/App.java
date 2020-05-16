package expectit;

import java.util.logging.Logger;
import static net.sf.expectit.matcher.Matchers.contains;
import static net.sf.expectit.matcher.Matchers.eof;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class App {

    private final static Logger log = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws IOException {
        new Triple().telnet();
    }
}
