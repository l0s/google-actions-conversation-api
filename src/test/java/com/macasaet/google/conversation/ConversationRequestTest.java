package com.macasaet.google.conversation;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;


public class ConversationRequestTest {

    private static final String example = "{\n" + 
            "  \"user\": {\n" + 
            "    \"user_id\": \"003ed57d-b2a6-46a8-8e29-19fa2aa7f553\",\n" + 
            "    \"profile\": {\n" + 
            "      \"given_name\": \"John\",\n" + 
            "      \"family_name\": \"Doe\",\n" + 
            "      \"display_name\": \"John Doe\"\n" + 
            "    },\n" + 
            "    \"access_token\": \"785b4fd0-c22c-4d33-a588-f6ed0d2ddf6a\"\n" + 
            "  },\n" + 
            "  \"device\": {\n" + 
            "    \"location\": {\n" + 
            "      \"coordinates\": {\n" + 
            "        \"latitude\": 37.422648,\n" + 
            "        \"longitude\": -122.083936\n" + 
            "      },\n" + 
            "      \"formatted_address\": \"1600 Amphitheatre Pkwy, Mountain View, CA 94043, United States\",\n" + 
            "      \"city\": \"Mountain View\",\n" + 
            "      \"zip_code\": \"94043\"\n" + 
            "    }\n" + 
            "  },\n" + 
            "  \"conversation\": {\n" + 
            "    \"conversation_id\": \"1732fdd4-4036-49d8-9a35-e47d57e2307e\",\n" + 
            "    \"type\": \"ACTIVE\",\n" + 
            "    \"conversation_token\": \"d8041d12-4e0c-4286-902d-05f068d5d738\"\n" + 
            "  },\n" + 
            "  \"inputs\": [\n" + 
            "    {\n" + 
            "      \"intent\": \"assistant.intent.action.MAIN\",\n" + 
            "      \"raw_inputs\": [\n" + 
            "        {\n" + 
            "          \"query\": \"...\"\n" + 
            "        }\n" + 
            "      ],\n" + 
            "      \"arguments\": [\n" + 
            "        {\n" + 
            "          \"name\": \"destination\",\n" + 
            "          \"raw_text\": \"SFO\",\n" + 
            "          \"location_value\": {\n" + 
            "            \"latlng\": {\n" + 
            "              \"latitude\": 37.620565,\n" + 
            "              \"longitude\": -122.384964\n" + 
            "            },\n" + 
            "            \"formatted_address\": \"1000 Broadway, San Francisco, CA 95133\"\n" + 
            "          }\n" + 
            "        }\n" + 
            "      ]\n" + 
            "    }\n" + 
            "  ]\n" + 
            "}";

    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        objectMapper = new ObjectMapper().configure(FAIL_ON_UNKNOWN_PROPERTIES, false).registerModule(new JaxbAnnotationModule());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public final void testGetUser() throws IOException {
        final ConversationRequest result = objectMapper.readValue(example, ConversationRequest.class);
        
        assertEquals( "003ed57d-b2a6-46a8-8e29-19fa2aa7f553", result.getUser().getUserId() );
        assertEquals( "1732fdd4-4036-49d8-9a35-e47d57e2307e", result.getConversation().getConversationId() );
    }

}
