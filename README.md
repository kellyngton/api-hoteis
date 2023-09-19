# api-hoteis
Desafio técnico: Hands On, criando api RESTful.


## Fluxo da API

![fluxo](https://github.com/kellyngton/api-hoteis/blob/main/Api-Hoteis.png)
figura1: exemplo do fluxo dos dados em uma requisição do cliente


Descrição: O desafio "Hands On" terá como objetivo analisar a performance e desenvolvimento do candidato que participará do processo seletivo. Vale ressaltar que o candidato terá que desenvolver um único endpoint utilizando spring boot e para esse endpoint o candidato terá que utilizar o open api para documentar o mesmo e testarmos via swagger.


Alguns pontos importantes:

- O candidato poderá realizar consultas durante a tarefa;

- O candidato deverá utilizar o spring initializr para criar a aplicação, ou então utilizar um template próprio de microserviços;


O que é obrigatório na tarefa?

- Java 11;

- Spring boot;

- Open API; Swagger;

- Bons padrões de desenvolvimentos;


O que terá na tarefa?

- Consumo de API;


O que não é obrigatório mais contará pontos extras valiosizimos:

- Padrão arquitetural Clean Arch;

- Pelo ao menos um teste unitário;



Desafio "Hands On"

O candidato deverá criar um serviço do tipo API RESTful, documentada com swagger, para realizar a consulta em uma api de um dos nossos parceiros, e exibir a listagem de hoteis por um determinado código de cidade. A sua entrega, deverá conter pelo ao menos um teste unitário, não exigimos teste de todos os modelos, logicas, métodos, etc.


Endpoints do serviço

Endpoint: GET - /hoteis/{codigoCidade}

Descrição: Retorna uma lista de hoteis pelo código da cidade;

Payload de retorno:

[

{

"hotel": "Hotel de teste 1",

"cidade": "Itaperuna",

"valorTotal": 5890.54

},

{

"hotel": "Hotel de teste 2",

"cidade": "Itaperuna",

"valorTotal": 6000.54

}

]

Regra de negócio: O valor que será populado no campo valorTotal será sempre o calculo de dois adultos mais uma criança;


Para fins de teste podemos utilizar os seguintes códigos de cidade: 1032 , 7110, 9626


API do nosso parceiro:
Nosso parceiro irá disponibilizar uma API de consulta de hotéis por cidade:


Descrição da API


URL: https://cvcbackendhotel.herokuapp.com/hotels/avail/{ID_da_Cidade}


Method: GET


A API responde os seguintes ID_da_Cidade:

1032 (Porto Seguro)
7110 (Rio de Janeiro)
9626 (São Paulo)
Exemplo:


URL: https://cvcbackendhotel.herokuapp.com/hotels/avail/1032


[{

"id": 1,

"name": "Hotel Teste 1",

"cityCode": 1032,

"cityName": "Porto Seguro",

"rooms": [

{

"roomID": 0,

"categoryName": "Standard",

"price": {

"adult": 1372.54,

"child": 848.61

}

}

]

}]


