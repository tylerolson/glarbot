function Command(name, args, commands) {
	this.name = name;
	this.args = args;
	commands.add(this);
}

module.exports = Command;
