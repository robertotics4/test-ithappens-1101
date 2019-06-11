const Filial = require('../models/Filial');

module.exports = {
    async index(req, res) {
        const filiais = await Filial.find({}).sort('_id');

        return res.json(filiais);
    },

    async store(req, res) {
        const filial = await Filial.create(req.body);

        return res.json(filial);
    },

    async deleteAll(req, res) {
        const filiais = await Filial.deleteMany({});

        return res.json(filiais);
    }
};