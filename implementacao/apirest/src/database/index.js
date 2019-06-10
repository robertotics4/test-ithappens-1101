const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/apiestoque', { useNewUrlParser: true });
mongoose.Promise = global.Promise;

module.exports = mongoose;