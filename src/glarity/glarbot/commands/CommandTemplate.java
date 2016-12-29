package glarity.glarbot.commands;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class CommandTemplate extends ListenerAdapter {

	@Override
	@SuppressWarnings("unused")
	public void onMessageReceived(MessageReceivedEvent event) {
		JDA jda = event.getJDA();
		long responseNumber = event.getResponseNumber();

		User author = event.getAuthor();
		Message message = event.getMessage();
		MessageChannel channel = event.getChannel();

		String msg = message.getContent();
		String[] msgParts = msg.split(" ");

		if (msg.equals("")) {
		}
	}

}
