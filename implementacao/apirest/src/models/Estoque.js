const mongoose = require('../database');
const Float = require('mongoose-float').loadType(mongoose, 2);

const EstoqueSchema = new mongoose.Schema({
    pedidos: [{
        type: mongoose.Schema.Types.ObjectId,
        ref: 'PedidoEstoque'
    }],
    produtos: [{
        type: mongoose.Schema.Types.ObjectId,
        ref: 'Produto'
    }],
    valorTotal: {
        type: Float,
        require: true,
    },
});

module.exports = mongoose.model('Estoque', EstoqueSchema);
