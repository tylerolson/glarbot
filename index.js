const Discord = require('discord.js');
const client = new Discord.Client();

client.on('ready', () => {
	console.log('I am ready!');
});

client.on('message', message => {
	if (message.content === 'ping') {
		message.reply('pong');
	}
});

client.login('MjYzMjEzNDE5ODQxMzIzMDA4.DMXbnQ.WxW0cxhLdRC-zD5Tmmi6baHZM1g');
