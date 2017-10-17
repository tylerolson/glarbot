function Command(name, commands) {
	this.name = name;
	commands.add(this);
}

module.exports = Command;
