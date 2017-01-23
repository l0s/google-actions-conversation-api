package com.macasaet.google.conversation;

import static com.macasaet.google.conversation.ConversationResponse.ask;
import static com.macasaet.google.conversation.ConversationResponse.tell;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.macasaet.google.conversation.ConversationResponse.AskResponseBuilder;
import com.macasaet.google.conversation.ConversationResponse.TellResponseBuilder;

/**
 * Test class for {@link ConversationResponse}. It validates the builder methods
 * for the examples provided in the documentation:
 * https://developers.google.com/actions/reference/conversation#http-response .
 *
 * <p>Copyright &copy; 2017 Carlos Macasaet.</p>
 *
 * @author Carlos Macasaet
 */
public class ConversationResponseTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public final void verifyTell() {
        // given
        final TellResponseBuilder builder = tell().withConversationToken("42").withTextToSpeech("Thanks for playing!");

        // when
        final ConversationResponse response = builder.build();

        // then
        assertFalse(response.isExpectUserResponse());
        final FinalResponse finalResponse = response.getFinalResponse();
        final SpeechResponse speechResponse = finalResponse.getSpeechResponse();
        assertEquals("Thanks for playing!", speechResponse.getTextToSpeech());
        assertNull(speechResponse.getSsml());
    }

    @Test
    public final void verifyAsk() {
        // given
        final AskResponseBuilder builder = ask().withConversationToken("42")
                .withInitialTextToSpeech("What is your next guess?").withNoInputTextToSpeech("I didn't hear a number.")
                .withNoInputTextToSpeech("If you're still there, what's your guess?")
                .withNoInputTextToSpeech("We can stop here. Let's play again soon.")
                .withExpectedIntentId("assistant.intent.action.TEXT");

        // when
        final ConversationResponse response = builder.build();

        // then
        assertTrue(response.isExpectUserResponse());
        final List<ExpectedInput> expectedInputs = response.getExpectedInputs();
        assertEquals(1, expectedInputs.size());
        final ExpectedInput expectedInput = expectedInputs.get(0);
        final InputPrompt inputPrompt = expectedInput.getInputPrompt();
        final List<SpeechResponse> initialPrompts = inputPrompt.getInitialPrompts();
        assertEquals(1, initialPrompts.size());
        final SpeechResponse initialPrompt = initialPrompts.get(0);
        assertEquals("What is your next guess?", initialPrompt.getTextToSpeech());
        assertNull(initialPrompt.getSsml());
        final List<SpeechResponse> noInputPrompts = inputPrompt.getNoInputPrompts();
        assertEquals(3, noInputPrompts.size());
        assertEquals("I didn't hear a number.", noInputPrompts.get(0).getTextToSpeech());
        assertEquals("If you're still there, what's your guess?", noInputPrompts.get(1).getTextToSpeech());
        assertEquals("We can stop here. Let's play again soon.", noInputPrompts.get(2).getTextToSpeech());
        final List<ExpectedIntent> possibleIntents = expectedInput.getPossibleIntents();
        assertEquals(1, possibleIntents.size());
        final ExpectedIntent possibleIntent = possibleIntents.get(0);
        assertEquals("assistant.intent.action.TEXT", possibleIntent.getIntent());
    }

}