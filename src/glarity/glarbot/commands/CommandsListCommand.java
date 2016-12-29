package glarity.glarbot.commands;

import glarity.glarbot.Glarbot;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class CommandsListCommand extends ListenerAdapter {

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		Message message = event.getMessage();
		MessageChannel channel = event.getChannel();

		String msg = message.getContent();

		if (msg.equalsIgnoreCase("?commands")) {
			channel.sendMessage(Glarbot.commands.toString()).queue();
		}
	}

}