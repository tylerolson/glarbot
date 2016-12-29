package glarity.glarbot.commands;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ShutdownCommand extends ListenerAdapter {

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		JDA jda = event.getJDA();
		User author = event.getAuthor();
		Message message = event.getMessage();

		String msg = message.getContent();

		if (msg.equalsIgnoreCase("~r") || author.getDiscriminator() == "7464" || author.getName() == "Glarity") {
			jda.shutdown(true);
		}
	}

}