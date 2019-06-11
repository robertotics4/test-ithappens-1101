const mongoose = require('../database');

const FilialSchema = new mongoose.Schema({
    estoque: {
        type: mongoose.Schema.Types.ObjectId,
        req: 'Estoque',
    },
    nome: {
        type: String,
        require: true,
    },
    cnpj: {
        type: String,
        require: true,
        unique: true,
    },
    telefone: {
        type: String,
        require: true,
    },
});

module.exports = mongoose.model('Filial', FilialSchema);
