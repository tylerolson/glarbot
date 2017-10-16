function Commands() {
	this.commandList = [];
	this.commandNameList = [];

	this.commandListener = function(message) {
		for (i = 0; i < this.commandList.length; i++) {
			if (message.content == this.commandList[i].name) {
				this.commandList[i].onCalled(message);
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
