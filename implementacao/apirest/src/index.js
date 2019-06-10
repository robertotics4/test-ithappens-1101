const express = require('express');
const bodyParser = require('body-parser');

const app = express();

const routes = require('./routes');

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(routes);


app.listen(3000, () => {
    console.log('Servidor iniciado na porta 3000');
});