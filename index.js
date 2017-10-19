const Discord = require('discord.js');
const client = new Discord.Client();
const config = require('./config.json');
const Command = require('./Command.js');
const CommandManager = require('./CommandManager.js');

//command stuff
var commandManager = new CommandManager();

var commandsCommand = new Command("!commands", commandManager);
commandsCommand.onCalled = function(message) {
	message.reply(commandManager.getCommandsNameList());
};

var getInfoCommand = new Command("!getinfo", commandManager);
getInfoCommand.onCalled = function(message, args) {
	if (args.length > 0) {
		if (args[0].startsWith("<@")) {
			var tempUser = client.users.get(args[0].replace("<@", "").replace(">", ""));
			message.reply("\nUsername: " + tempUser.username + "\nDiscriminator: #" + tempUser.discriminator);
		} else {
			message.reply("You must tag a user!");
		}
	} else {
		message.reply("You must tag a user!");
	}
};

var pingCommand = new Command("!ping", commandManager);
pingCommand.onCalled = function(message, args) {
	message.reply("Pong! " + args + " " + message.member.id);
};

//server stuff
client.on('ready', function() {
	client.user.setPresence(config.presence);
	console.log('I am ready!');
});

client.on('message', function(message) {
	commandManager.commandListener(message);
});

client.login(config.token);
