
package org.mwatt.service;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

@WireMockTest
public class HttpServiceImplTest {

        private final HttpService httpService = new HttpServiceImpl();

        @Test
        public void testGet() throws Exception {
            Map<String, String> response = httpService.get(new URI("http://localhost:8080/test"), Map.class);
            assertEquals(new HashMap<>(), response);
        }
}
