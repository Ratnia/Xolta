import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class PingPongBot extends ListenerAdapter {

    public static void main(String[] args) throws LoginException {
        String token = "BOT_TOKEN"; // Replace with your bot token
        JDABuilder.createDefault(token)
                .addEventListeners(new PingPongBot())
                .build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        // Ignore messages from bots
        if (event.getAuthor().isBot()) return;

        String message = event.getMessage().getContentRaw();

        if (message.equalsIgnoreCase("ping")) {
            event.getChannel().sendMessage("pong!").queue();
        }
    }
}
