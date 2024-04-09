package org.mwatt.service;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.net.URI;

public interface HttpService {
    <T> T get(URI uri, Class<T> responseType) throws IOException, InterruptedException;
}

