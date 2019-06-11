const express = require('express');

const routes = express.Router();

const UsuarioController = require('./controllers/UsuarioController');
const ProdutoController = require('./controllers/ProdutoController');
const FilialController = require('./controllers/FilialController');

routes.get('/usuarios', UsuarioController.index);
routes.post('/usuarios', UsuarioController.store);
routes.delete('/usuarios', UsuarioController.deleteAll);

routes.get('/produtos', ProdutoController.index);
routes.post('/produtos', ProdutoController.store);
routes.delete('/produtos', ProdutoController.deleteAll);

routes.get('/filiais', FilialController.index);
routes.post('/filiais', FilialController.store);
routes.delete('/filiais', FilialController.deleteAll);


module.exports = routes;