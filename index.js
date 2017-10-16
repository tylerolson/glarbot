const Discord = require('discord.js');
const client = new Discord.Client();
const Command = require('./command.js');
const Commands = require('./commands.js');

var commands = new Commands();

var helpCommand = new Command("!help", "");
helpCommand.onCalled = function(message) {
	message.reply("Working!");
};

commands.add(helpCommand);

client.on('ready', () => {
	console.log('I am ready!');
});

client.on('message', message => {
	commands.commandListener(message);
	if (message.content === 'ping') {
		message.reply('pong');
	}
});

client.login('MjYzMjEzNDE5ODQxMzIzMDA4.DMXbnQ.WxW0cxhLdRC-zD5Tmmi6baHZM1g');
