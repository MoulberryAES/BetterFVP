package org.champenslabyaddons.fvp.util.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnector {
  public static HttpURLConnection getOpenHttpConnection(URL source) throws IOException {
    return (HttpURLConnection) source.openConnection();
  }
}
