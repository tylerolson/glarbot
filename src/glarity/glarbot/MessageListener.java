package glarity.glarbot;

import java.util.ArrayList;

import net.dv8tion.jda.client.entities.Group;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {

	@Override
	@SuppressWarnings("unused")
	public void onMessageReceived(MessageReceivedEvent event) {
		// These are provided with every event in JDA
		JDA jda = event.getJDA(); // JDA, the core of the api.
		long responseNumber = event.getResponseNumber();

		// Event specific information
		User author = event.getAuthor();
		Message message = event.getMessage();
		MessageChannel channel = event.getChannel();

		String msg = message.getContent(); // String version of message
		String[] msgParts = msg.split(" ");
		
		ArrayList<String> commands = new ArrayList<String>();
		commands.add("?glarbot");
		commands.add("?help");
		commands.add("?clear");
		
		if (event.isFromType(ChannelType.TEXT)) {

			Guild guild = event.getGuild();
			TextChannel textChannel = event.getTextChannel();
			Member member = event.getMember();
			String name = member.getEffectiveName();

			System.out.printf("(%s)[%s]<%s>: %s\n", guild.getName(), textChannel.getName(), name, msg);
		} else if (event.isFromType(ChannelType.PRIVATE)) {
			PrivateChannel privateChannel = event.getPrivateChannel();

			System.out.printf("[PRIV]<%s>: %s\n", author.getName(), msg);
		} else if (event.isFromType(ChannelType.GROUP)) {
			Group group = event.getGroup();
			String groupName = group.getName() != null ? group.getName() : "";
			System.out.printf("[GRP: %s]<%s>: %s\n", groupName, author.getName(), msg);
		}
		
		if (msg.equalsIgnoreCase("~r") || author.getDiscriminator() == "7464" || author.getName() == "Glarity") {
			jda.shutdown(true);
		}
		
		if (msg.contains("alex")) {
			channel.sendMessage("https://www.youtube.com/watch?v=NFACFmeyqJw").queue();
		}

		if (msg.equalsIgnoreCase("?glarbot") || msg.equals("?help")) {
			channel.sendMessage("Glarbot is a Discord bot made by Glarity. Start with ?commands.").queue();
		}

		if (msg.equalsIgnoreCase("?commands")) {
			channel.sendMessage(commands.toString()).queue();
		}

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