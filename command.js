module.exports = function Command(name, args) {
	this.name = name;
	this.args = args;

	this.onCalled = function(message) {};
};
