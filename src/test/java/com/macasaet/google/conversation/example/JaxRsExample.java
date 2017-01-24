package com.macasaet.google.conversation.example;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.macasaet.google.conversation.ConversationResponse.ask;
import static com.macasaet.google.conversation.ConversationResponse.tell;
import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableSet;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import com.macasaet.google.conversation.ConversationRequest;
import com.macasaet.google.conversation.ConversationResponse;

/**
 * Example of how to create an Actions on Google agent webhook using the Java
 * API for RESTful Services (JAX-RS).
 *
 * <p>Copyright &copy; 2017 Carlos Macasaet.</p>
 *
 * @author Carlos Macasaet
 */
public class JaxRsExample {

    /**
     * Example JAX-RS REST Resource
     */
    @Path("/api/webhook/v1")
    public static class Resource {

        @Path("/endgame")
        @Consumes("application/json")
        @Produces("application/json")
        @POST
        public ConversationResponse endGame(final ConversationRequest request,
                @Context final HttpServletResponse servletResponse) {
            servletResponse.setHeader("Google-Assistant-API-Version", "v1");

            return tell().withConversationToken("42").withTextToSpeech("Thanks for playing!").build();
        }

        @Path("/guessnumber")
        @Consumes("application/json")
        @Produces("application/json")
        @POST
        public ConversationResponse guessNumber(final ConversationRequest request,
                @Context final HttpServletResponse servletResponse) {
            servletResponse.setHeader("Google-Assistant-API-Version", "v1");

            return ask().withConversationToken("42").withInitialTextToSpeech("What is your next guess?")
                    .withNoInputTextToSpeech("I didn't hear a number.")
                    .withNoInputTextToSpeech("If you're still there, what's your guess?")
                    .withNoInputTextToSpeech("We can stop here. Let's play again soon.")
                    .withExpectedIntentId("assistant.intent.action.TEXT").build();
        }
    }

    /**
     * This {@link ContextResolver} demonstrates how to configure a Jackson
     * ObjectMapper to serialise and deserialise the POJOs in a way compatible
     * with Assistant.
     *
     * If you are using Jersey, register the package
     * "org.glassfish.jersey.examples.jackson" and register this
     * {@link ContextResolver}. For other JAX-RS providers, see:
     * <a href="https://github.com/FasterXML/jackson-jaxrs-providers">https://
     * github.com/FasterXML/jackson-jaxrs-providers</a> .
     */
    @Provider
    public static class ObjectMapperResolver implements ContextResolver<ObjectMapper> {
        public ObjectMapper getContext(final Class<?> type) {
            final ObjectMapper retval = new ObjectMapper();
            // if the incoming JSON contains properties not defined in the object model, ignore them
            retval.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
            // use the JAX-B annotations to map the fields in the Conversation Protocol to the object model
            retval.registerModule(new JaxbAnnotationModule());
            // don't write out properties that are null or empty
            retval.setSerializationInclusion(NON_EMPTY);
            return retval;
        }
    }

    /**
     * Example Actions on Google agent JAX-RS application. See the note on
     * {@link ObjectMapperResolver} about registering the JSON library.
     */
    @ApplicationPath("/")
    public static class ExampleApplication extends Application {
        public Set<Class<?>> getClasses() {
            return unmodifiableSet(new HashSet<>(asList(ObjectMapperResolver.class, Resource.class)));
        }
    }

}