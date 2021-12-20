package org.popins.dev;

import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.popins.dev.model.Quote;

import io.smallrye.mutiny.Multi;

import javax.ws.rs.core.MediaType;
@Path("/quotes")
public class QuotesResource {
	
	@Channel("quote-requests")
    Emitter<String> quoteRequestEmitter;
	
	@POST
    @Path("/request")
    @Produces(MediaType.TEXT_PLAIN)
    public String createRequest() {
        UUID uuid = UUID.randomUUID();
        quoteRequestEmitter.send(uuid.toString());
        return uuid.toString();
    }
	
	 @Channel("quotes")
	 Multi<Quote> quotes;
	 
	 @GET
	 @Produces(MediaType.SERVER_SENT_EVENTS) // denotes that server side events (SSE) will be produced
	 public Multi<Quote> stream() {
	        return quotes.log();
	    }

}
