# google-actions-conversation-api

Java POJOs / DTOs / domain objects  for the Actions on Google Conversation API: https://developers.google.com/actions/reference/conversation

[![Build Status](https://travis-ci.org/l0s/google-actions-conversation-api.svg?branch=master)](https://travis-ci.org/l0s/google-actions-conversation-api)

## Including this in your project

Maven:

    <dependency>
      <groupId>com.macasaet.google.conversation</groupId>
      <artifactId>google-actions-conversation-api</artifactId>
      <version>0.0.8</version>
    </dependency>

## Example Usage

These objects can be used with Jersey like so:

    @Path("/webhook")
    @Consumes("application/json")
    @Produces("application/json")
    @POST
    public ConversationResponse handle(final ConversationRequest request,
            @Context final HttpServletResponse servletResponse) {
        servletResponse.setHeader("Google-Assistant-API-Version", "v1");

        final SpeechResponse speechResponse = new SpeechResponse();
        speechResponse.setTextToSpeech("Hello!");
        final FinalResponse finalResponse = new FinalResponse();
        finalResponse.setSpeechResponse(speechResponse);
        final ConversationResponse response = new ConversationResponse();
        response.setConversationToken(request.getConversationToken());
        response.setFinalResponse(finalResponse);
        return response;
    }

## Caveats

Ensure that your JSON library is configured to:
* not fail if it encounters unknown properties (during deserialisation of JSON to POJO)
* exclude fields that are `null` or empty (during serialisation of POJO to JSON)

## Uploading to Maven Central

    mvn --batch-mode -Prelease clean release:clean release:prepare release:perform

Then, commit and push changes.
