const Produto = require('../models/Produto');

module.exports = {
    async index(req, res) {
        const produtos = await Produto.find({}).sort('_id');

        return res.json(produtos);
    },

    async store(req, res) {
        const produto = await Produto.create(req.body);

        return res.json(produto);
    },

    async deleteAll(req, res) {
        const produtos = await Produto.deleteMany({});

        return res.json(produtos);
    }
};