# Sistema de Gerenciamento de Coleção Biológica

---

## Sobre o projeto

Trabalho final da disciplina de Programação Orientada a Objetos:

O Laboratório de Biodiversidade da UFJ mantém uma coleção científica de espécimes biológicos provenientes de pesquisas, inventários ecológicos, monitoramentos ambientais e projetos de conservação. Cada exemplar recebe um ID único, e precisa ter seus dados taxonômicos registrados.

Este projeto implementa um sistema em Java, seguindo o padrão DAO, que permite gerenciar essa coleção, aplicando corretamente os quatro pilares da Orientação a Objetos.

## Dados de cada exemplar:

| Campo | Descrição |
|---|---|
| ID Tombo | Identificador único do exemplar |
| Reino | Classificação taxonômica |
| Filo | Classificação taxonômica |
| Classe | Classificação taxonômica |
| Ordem | Classificação taxonômica |
| Família | Classificação taxonômica |
| Gênero | Classificação taxonômica |
| Espécie | Classificação taxonômica |
| Localidade da Coleta | Local onde o exemplar foi coletado |
| UF | Estado da coleta |
| Data da Coleta | Data em que o exemplar foi coletado |
| Coletor | Responsável pela coleta |
| Identificador | Responsável pela identificação taxonômica |
| Observações | Anotações científicas adicionais |

## Requisitos:

- **RF01 — Cadastro de Exemplar**: cadastrar um novo exemplar biológico.
- **RF02 — Consulta de Exemplar**: localizar exemplares por ID de Tombo, Espécie, Gênero, Coletor ou Estado (UF).
- **RF03 — Atualização de Dados**: alterar informações de exemplares já cadastrados.
- **RF04 — Exclusão de Registros**: remover exemplares do sistema.
- **RF05 — Listagem Geral**: visualizar todos os exemplares cadastrados.
- **RF05 — Interface Gráfica (GUI)**: interação via interface gráfica.

## Arquitetura
```text
src/
├── application/
│   └── Program.java
├── gui/
│   ├── JanelaAtualizar.java
│   ├── JanelaCadastrar.java
│   ├── JanelaConsultar.java
│   ├── JanelaMenu.java
│   └── JanelaRemover.java
└── model/
    ├── dao/
    │   ├── impl/
    │   │   ├── ExemplarDaoFiles.java
    │   │   ├── ExemplarDaoJson.java
    │   │   └── LocalDateAdapter.java
    │   ├── DaoFactory.java
    │   └── ExemplarDao.java
    └── entities/
        ├── Coletor.java
        └── Exemplar.java
```

## Tecnologias:

- Java
- Swing (GUI)
- Padrão DAO
- Persistência em JSON (via [Gson](https://github.com/google/gson))

## Configuração do ambiente

`.jar` do Gson (versão 2.10.1):
    https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar