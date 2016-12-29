package glarity.glarbot;

import java.util.ArrayList;

import glarity.glarbot.commands.ClearCommand;
import glarity.glarbot.commands.CommandsListCommand;
import glarity.glarbot.commands.InfoCommand;
import glarity.glarbot.commands.ShutdownCommand;
import glarity.glarbot.utils.Glarity;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;

public class Glarbot {
	
	public static ArrayList<String> commands = new ArrayList<String>();

	public static void main(String[] args) {
		try {
			JDA jda = new JDABuilder(AccountType.BOT).setToken(Glarity.token).buildBlocking();
			commands.add("?clear");
			commands.add("?commands");
			commands.add("?info");
			commands.add("?glarbot");
			commands.add("?help");
			jda.setAutoReconnect(true);
			jda.addEventListener(new MessageListener());
			jda.addEventListener(new ClearCommand());
			jda.addEventListener(new CommandsListCommand());
			jda.addEventListener(new InfoCommand());
			jda.addEventListener(new ShutdownCommand());
			jda.getPresence().setGame(Game.of("hehe xd"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}