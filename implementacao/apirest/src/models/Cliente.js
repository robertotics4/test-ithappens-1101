const mongoose = require('../database');

const ClienteSchema = new mongoose.Schema({
    nome: {
        type: String,
        require: true,
    },
    endereco: {
        type: String,
        require: true,
    },
    telefone: {
        type: String,
        require: true,
    },
});

module.exports = mongoose.model('Cliente', ClienteSchema);
