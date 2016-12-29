package glarity.glarbot.commands;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class InfoCommand extends ListenerAdapter {

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		Message message = event.getMessage();
		MessageChannel channel = event.getChannel();

		String msg = message.getContent();

		if (msg.equalsIgnoreCase("?info") || msg.equals("?glarbot") || msg.equals("?help")) {
			channel.sendMessage("Glarbot is a Discord bot made by Glarity. Start with ?commands.").queue();
		}

	}

}