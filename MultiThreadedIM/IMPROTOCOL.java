
import java.net.*;
import java.io.*;

public class IMPROTOCOL {
    private static final int WAITING = 0;
    private static final int IN_CONVERSATION = 1;

    private static final int followup = 6;

    private int state = WAITING;
    private int count = 0; 
    private String[] followups = { "What's your favorite color?",
            "What's your favorite fruit?",
            "Tell me about yourself.",
            "Do you drive?",
            "What's your favorite movie?",
            "How's life?" };

    public String processInput(String theInput) {
        String theOutput = null;

        if (state == WAITING) {
            theOutput = "Hello! How are you? (Say 'bye' at any time to end the conversation)";
            System.out.println(theOutput);
            state = IN_CONVERSATION;
        } else if (state == IN_CONVERSATION) {
            if (!theInput.isEmpty()) {
                System.out.println(theInput);
                theOutput = followups[count];
                System.out.println(theOutput);
                count++; 
                state = IN_CONVERSATION;
                if(count >= 6){
                    count = 0;
                } 
            }             else {
                theOutput = "Bye";
                System.out.println(theOutput); 
            }
            if(theInput.equalsIgnoreCase("Bye")) {
                System.exit(0);
            }
        }
        return theOutput;
    }
}
