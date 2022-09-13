package org.apache.coyote.http11.handler;

import java.io.IOException;
import org.apache.coyote.http11.request.HttpRequest;
import org.apache.coyote.http11.response.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Handler {

    protected static final Logger log = LoggerFactory.getLogger(Handler.class);

    public abstract HttpResponse handle(final HttpRequest request) throws IOException;
}
