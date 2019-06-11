const mongoose = require('../database');
const Float = require('mongoose-float').loadType(mongoose, 2);

const PedidoEstoqueSchema = new mongoose.Schema({
    tipoPedido: {
        type: String,
        require: true,
        enum: ["ENTRADA", "SAIDA"],
    },
    filial: {
        type: mongoose.Schema.Types.ObjectId,
        ref: 'Filial',
    },
    usuario: {
        type: mongoose.Schema.Types.ObjectId,
        req: 'Usuario'
    },
    cliente: {
        type: mongoose.Schema.Types.ObjectId,
        req: 'Cliente',
    },
    observacao: {
        type: String,
        require: true,
    },
    itensPedido: [{
        type: mongoose.Schema.Types.ObjectId,
        req: 'ItemPedido',
    }],
    formaPagamento: {
        type: mongoose.Schema.Types.ObjectId,
        req: 'FormaPagamento',
    },
    valorTotal: {
        type: Float,
        require: true,
    },
});

module.exports = mongoose.model('PedidoEstoque', PedidoEstoqueSchema);
