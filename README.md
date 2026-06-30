# ufj-oop-final-project


TRABALHO FINAL PROGRAMAÇÃO ORIENTAÇÃO À OBJETO
Curso: Ciência da Computação
Disciplina: Programação Orientação à Objeto
Semestre: 1 /2026
Docente: Fabrício Alves Rodrigues
O Laboratório de Biodiversidade da Universidade Federal de Jataí (UFJ) possui uma
coleção científica composta por espécimes biológicos provenientes de pesquisas,
inventários ecológicos, monitoramentos ambientais e projetos de conservação. Toda
coleção científica depende de um processo rigoroso de curadoria, no qual cada
exemplar recebe um número de tombo que o identifica de forma única dentro do
acervo. Além do armazenamento físico, é necessário manter um sistema
computacional capaz de registrar, consultar, atualizar e organizar as informações
taxonômicas e geográficas associadas aos exemplares.
Atualmente o laboratório deseja informatizar esse processo por meio de um sistema
orientado a objetos que permita gerenciar os registros da coleção biológica de forma
segura, organizada e extensível. Como desenvolvedor responsável pelo projeto, você
deverá analisar o problema, identificar as entidades do domínio e construir uma
solução utilizando corretamente os princípios da Programação Orientada a Objetos.
Desafio
Cada exemplar possui informações taxonômicas, dados de coleta, pessoas
responsáveis pela coleta e identificação, observações científicas e um número de
tombo único. Ao mesmo tempo, o sistema deverá ser robusto o suficiente para evitar
erros de entrada de dados e permitir futuras expansões do laboratório.
Como modelar um sistema capaz de representar adequadamente um acervo
biológico utilizando os princípios da Programação Orientada a Objetos?
Quais classes devem existir?
Quais responsabilidades pertencem a cada classe?
Como os quatro pilares da orientação a objetos podem ser utilizados para tornar o
sistema mais flexível e reutilizável?
Como impedir que informações inválidas sejam cadastradas no sistema?
Especificação do Sistema
O sistema deverá permitir o gerenciamento de exemplares biológicos tombados no
Laboratório de Biodiversidade da UFJ.
Cada exemplar deverá possuir, no mínimo, os seguintes dados:
Campo
ID Tombo
Reino
Filo
Classe
Ordem
Família
Gênero
Espécie
Localidade da
Coleta
UF
Data da Coleta
Coletor
Identificador
Observações
Requisitos Funcionais obrigatórios no trabalho
O sistema deverá possuir, no mínimo:
RF01 – Cadastro de Exemplar
Permitir cadastrar um novo exemplar biológico.
RF02 – Consulta de Exemplar
Permitir localizar exemplares por:
ID de Tombo;
Espécie;
Gênero;
Coletor;
Estado (UF).
RF03 – Atualização de Dados
Permitir alterar informações de exemplares já cadastrados.
RF04 – Exclusão de Registros
Permitir remover exemplares do sistema.
RF05 – Listagem Geral
Permitir visualizar todos os exemplares cadastrados.
RF05 – Apresentar um GUI
Permitir que o usuário faça uso de uma interface gráfica.
