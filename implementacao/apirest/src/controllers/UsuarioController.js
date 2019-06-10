const Usuario = require('../models/Usuario');

module.exports = {
    async index(req, res) {
        const usuarios = await Usuario.find({}).sort('nome');

        return res.json(usuarios);
    },

    async store(req, res) {
        const usuario = await Usuario.create(req.body);

        return res.json(usuario);
    },

    async deleteAll(req, res) {
        const usuarios = await Usuario.deleteMany({});

        return res.json(usuarios);
    }
};