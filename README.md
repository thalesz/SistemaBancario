#Sistema Bancário

Este é um sistema bancário em Java composto por três classes: Conta, Agencia e Banco. O sistema permite criar e gerenciar contas bancárias em diferentes agências de um banco.

## Classe Conta
Possui os atributos: numero (int), nome (String) e saldo (double).
Possui um construtor que inicializa o número e o nome da conta, e define o saldo como zero.
Possui métodos para definir e obter o número, nome e saldo da conta.
Possui métodos para realizar depósitos, saques e transferências entre contas.

## Classe Agencia
Possui os atributos: numero (int), nome (String), numCt (int) e contas (array de Conta).
Possui um construtor que inicializa o número e nome da agência, e cria um array vazio para armazenar as contas.
Possui métodos para criar e remover contas, listar as contas da agência e selecionar uma conta pelo número.

##Classe Banco
Possui os atributos: nome (String) e agencias (array de Agencia).
Possui um construtor que inicializa o nome do banco e cria um array vazio para armazenar as agências.
Possui métodos para criar e remover agências, listar as agências do banco e selecionar uma agência pelo número.
O sistema é simples e permite a criação, remoção, listagem e gerenciamento de contas em diferentes agências de um banco. É possível realizar depósitos, saques e transferências entre contas.
