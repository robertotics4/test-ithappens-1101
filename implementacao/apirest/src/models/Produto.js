const mongoose = require('../database');
const Float = require('mongoose-float').loadType(mongoose, 2);

const ProdutoSchema = new mongoose.Schema({
    codigoBarras: {
        type: String,
        require: true,
        unique: true,
    },
    descricao: {
        type: String,
        require: true,
    },
    categoria: {
        type: String,
        require: true,
    },
    precoCusto: {
        type: Float,
        require: true,
    },
    precoVenda: {
        type: Float,
        require: true,
    },
});

module.exports = mongoose.model('Produto', ProdutoSchema);
