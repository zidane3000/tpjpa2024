package kahoot;


import io.undertow.Undertow;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

import org.apache.log4j.Logger;

public class RestServer {
    private static final Logger logger = Logger.getLogger(RestServer.class);

    public static void main( String[] args ) {

            UndertowJaxrsServer ut = new UndertowJaxrsServer();

            TestApplication ta = new TestApplication();


            ut.deploy(ta);

            ut.start(
                    Undertow.builder()
                            .addHttpListener(8080, "localhost")

            );
        logger.info("JAX-RS based micro-service running!");
    }
}
