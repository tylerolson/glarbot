const Discord = require('discord.js');
const client = new Discord.Client();
const config = require('./config.json');
const Command = require('./command.js');
const Commands = require('./commands.js');

//command stuff
var commands = new Commands();

var commandsCommand = new Command("!commands", commands);
commandsCommand.onCalled = function(message) {
	message.reply(commands.commandNameList);
};

var getInfoCommand = new Command("!getinfo", commands);
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

var pingCommand = new Command("!ping", commands);
pingCommand.onCalled = function(message, args) {
	message.reply("Pong! " + args + " " + message.member.id);
};

//server stuff
client.on('ready', function() {
	client.user.setPresence({
		status: "dnd",
		game: {
			name: "made by @Glarity",
		}
	});
	console.log('I am ready!');
});

client.on('message', function(message) {
	commands.commandListener(message);
});

client.login(config.token);
