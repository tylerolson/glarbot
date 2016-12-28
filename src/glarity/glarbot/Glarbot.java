package glarity.glarbot;

import glarity.glarbot.utils.Glarity;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;

public class Glarbot {
	
	public static void main(String[] args) {
		try {
		JDA jda = new JDABuilder(AccountType.BOT).setToken(Glarity.token).addListener(new MessageListener()).buildBlocking();
		jda.setAutoReconnect(true);
		jda.getPresence().setGame(Game.of("hehe xd"));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}