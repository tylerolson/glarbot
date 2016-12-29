package glarity.glarbot.commands;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ClearCommand extends ListenerAdapter {

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		Message message = event.getMessage();
		MessageChannel channel = event.getChannel();

		String msg = message.getContent();
		String[] msgParts = msg.split(" ");

		if (msg.startsWith("?clear")) {
			if (msgParts.length != 2) {
				channel.sendMessage("Usage: ?clear (amount)").queue();
			} else if (Integer.parseInt(msgParts[1]) < 2 || Integer.parseInt(msgParts[1]) > 100) {
				channel.sendMessage("Must provide at least 2 or at most 100 messages to be deleted.").queue();
			} else if (msgParts.length == 2) {
				event.getTextChannel().getHistory().retrievePast(Integer.parseInt(msgParts[1])).queue(messages -> event.getTextChannel().deleteMessages(messages).queue());
			}
		}

	}

}