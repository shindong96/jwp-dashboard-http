package org.apache.coyote.http11.request;

public class HttpRequestLine {

    private static final String QUERY_STRING_PREFIX = "?";

    private final HttpMethod method;
    private final String uri;

    public HttpRequestLine(final HttpMethod method, final String uri) {
        this.method = method;
        this.uri = uri;
    }

    public static HttpRequestLine from(final String startLine) {
        final String[] startLineContents = startLine.split(" ");

        final String method = startLineContents[0];
        final String uri = startLineContents[1];

        return new HttpRequestLine(HttpMethod.valueOf(method), takeUri(uri));
    }

    private static String takeUri(final String uriAndQueryParams) {
        if (!uriAndQueryParams.contains(QUERY_STRING_PREFIX)) {
            return uriAndQueryParams;
        }
        final int indexOfQueryStringPrefix = uriAndQueryParams.indexOf(QUERY_STRING_PREFIX);

        return uriAndQueryParams.substring(0, indexOfQueryStringPrefix);
    }


    public HttpMethod getMethod() {
        return method;
    }

    public String getUri() {
        return uri;
    }
}
