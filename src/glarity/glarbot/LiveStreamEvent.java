package glarity.glarbot;

import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.events.user.UserGameUpdateEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class LiveStreamEvent extends ListenerAdapter {

	@Override
	public void onUserGameUpdate(UserGameUpdateEvent event) {
		if (event.getGuild().getMember(event.getUser()).getGame() == null) {
			return;
		} else if (event.getGuild().getMember(event.getUser()).getGame().getType() == Game.GameType.TWITCH) {
			event.getGuild().getTextChannelById("236692599094771712").sendMessage(event.getUser().getName() + " is live!").queue();
			event.getGuild().getTextChannelById("130526729067429888").sendMessage(event.getUser().getName() + " is live!").queue();
		}
	}
}
// event.getUser().getName() == "BuzzVamp" && event.getUser().getDiscriminator()
// == "9872" &&