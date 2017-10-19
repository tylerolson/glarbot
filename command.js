function Command(name, commandManager) {
	this.name = name;
	commandManager.add(this);
}

module.exports = Command;
