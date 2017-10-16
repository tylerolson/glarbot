const Discord = require('discord.js');
const client = new Discord.Client();
const Command = require('./command.js');
const Commands = require('./commands.js');

//command stuff
var commands = new Commands();

var commandsCommand = new Command("!commands", "", commands);
commandsCommand.onCalled = function(message) {
	message.reply(commands.commandNameList);
};

var pingCommand = new Command("!ping", "", commands);
pingCommand.onCalled = function(message) {
	message.reply("Pong!");
};

//server stuff
client.on('ready', function() {
	console.log('I am ready!');
});

client.on('message', function(message) {
	commands.commandListener(message);
});

client.login('MjYzMjEzNDE5ODQxMzIzMDA4.DMXbnQ.WxW0cxhLdRC-zD5Tmmi6baHZM1g');
