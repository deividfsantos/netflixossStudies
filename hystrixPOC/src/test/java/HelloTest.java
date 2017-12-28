
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloTest {

        @Test
        public void testSynchronous() {

            assertEquals("Hello World!", new CommandHelloWorld("World").execute());
            assertEquals("Hello Bob!", new CommandHelloWorld("Bob").execute());
        }

        @Test
        public void testAsynchronous1() throws Exception {
            assertEquals("Hello World!", new CommandHelloWorld("World").queue().get());
            assertEquals("Hello Bob!", new CommandHelloWorld("Bob").queue().get());
        }

    }

