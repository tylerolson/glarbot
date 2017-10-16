module.exports = function() {
	this.commands = [];

	this.commandListener = function(message) {
		for (i = 0; i < this.commands.length; i++) {
			if (message.content == this.commands[i].name) {
				this.commands[i].onCalled(message);
			}
		}
	};

	this.add = function(command) {
		this.commands.push(command);
	};
};
