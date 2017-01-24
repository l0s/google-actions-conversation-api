# google-actions-conversation-api

Java POJOs / DTOs / domain objects  for the Actions on Google Conversation API: https://developers.google.com/actions/reference/conversation

[![Build Status](https://travis-ci.org/l0s/google-actions-conversation-api.svg?branch=master)](https://travis-ci.org/l0s/google-actions-conversation-api)
[![Javadocs](http://javadoc.io/badge/com.macasaet.google.conversation/google-actions-conversation-api.svg)](http://javadoc.io/doc/com.macasaet.google.conversation/google-actions-conversation-api)

## Including this in your project

The artifact is available in [Maven Central](https://repo1.maven.org/maven2/com/macasaet/google/conversation/google-actions-conversation-api/).

Example:

    <dependency>
      <groupId>com.macasaet.google.conversation</groupId>
      <artifactId>google-actions-conversation-api</artifactId>
      <version>0.0.14</version>
    </dependency>

## Example Usage

These objects can be used with JAX-RS like so:

    @Path("/webhook/guessnumber")
    @Consumes("application/json")
    @Produces("application/json")
    @POST
    public ConversationResponse guessNumber(final ConversationRequest request,
            @Context final HttpServletResponse servletResponse) {
        servletResponse.setHeader("Google-Assistant-API-Version", "v1");

        return ConversationResponse.ask().withConversationToken("42")
        		.withInitialTextToSpeech("What is your next guess?")
                .withNoInputTextToSpeech("I didn't hear a number.")
                .withNoInputTextToSpeech("If you're still there, what's your guess?")
                .withNoInputTextToSpeech("We can stop here. Let's play again soon.")
                .withExpectedIntentId("assistant.intent.action.TEXT").build();
    }

See the full example and more in the [test directory](https://github.com/l0s/google-actions-conversation-api/tree/master/src/test/java/com/macasaet/google/conversation).

## Caveats

Ensure that your JSON library is configured to:
* not fail if it encounters unknown properties (during deserialisation of JSON to POJO)
* exclude fields that are `null` or empty (during serialisation of POJO to JSON)

## Uploading to Maven Central

    mvn --batch-mode -Prelease clean release:clean release:prepare release:perform

Then, commit and push changes.
