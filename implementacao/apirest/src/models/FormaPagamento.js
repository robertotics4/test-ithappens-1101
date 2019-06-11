const mongoose = require('../database');

const FormaPagamentoSchema = new mongoose.Schema({
    descricao: {
        type: String,
        require: true,
        enum: ["DINHEIRO", "DEBITO", "CARTAO"],
    },
});

module.exports = mongoose.model('FormaPagamento', FormaPagamentoSchema);
