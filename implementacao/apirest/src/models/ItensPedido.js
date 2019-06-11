const mongoose = require('../database');
const Float = require('mongoose-float').loadType(mongoose, 2);

const ItemPedidoSchema = new mongoose.Schema({
    produto: {
        type: mongoose.Schema.Types.ObjectId,
        ref: 'Produto'
    },
    statusItem: {
        type: String,
        require: true,
        enum: ["ATIVO", "CANCELADO", "PROCESSADO"],
        default: "ATIVO",
    },
    quantidade: {
        type: Number,
        require: true,
    },
    valorUnitario: {
        type: Float,
        require: true,
    },
});

module.exports = mongoose.model('ItemPedido', ItemPedidoSchema);
