const express = require('express');

const routes = express.Router();

const UsuarioController = require('./controllers/UsuarioController');
const ProdutoController = require('./controllers/ProdutoController');

routes.get('/users', UsuarioController.index);
routes.post('/users', UsuarioController.store);
routes.delete('/users', UsuarioController.deleteAll);

routes.get('/products', ProdutoController.index);
routes.post('/products', ProdutoController.store);
routes.delete('/products', ProdutoController.deleteAll);

module.exports = routes;