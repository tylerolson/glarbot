function Commands() {
	this.commandList = [];
	this.commandNameList = [];

	this.commandListener = function(message) {
		for (i = 0; i < this.commandList.length; i++) {
			if (message.content.toLowerCase().startsWith(this.commandList[i].name)) {
				console.log("MSG > " + message.content);
				var tempArgs = message.content.trim().split(/ +/g);
				tempArgs.shift();
				this.commandList[i].onCalled(message, tempArgs);
			}
		}
	};

	this.add = function(command) {
		this.commandList.push(command);
		this.commandNameList += command.name + " ";
	};

	this.getCommandsList = function() {
		return this.commandsList;
	};

	this.getCommandsNameList = function() {
		return this.commandNameList;
	};
}

module.exports = Commands;
