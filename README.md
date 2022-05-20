# group-tasks-manager-api

Este projeto visa ser uma api que suporta um sistema de organização de tarefas para um grupo de pessoas. 

## Funcionalidades

- Cadastro de usuários
- Cadastro de grupos de usuários
- Cadastro de tarefas
- Cadastro de plataformas externas
- Listagem de tasks de um grupo
- Listagem de grupos de um usuário

## Especificações funcionais

- As tarefas são limitadas aos grupos a que são cadastradas
- Cada membro de um grupo é vinculado a tarefas, de forma que por um determinado periodo estas são sua responsabilidade
- Tarefas podem ser recorrentes ou não
- Um usuário pode participar de vários grupos
- Um membro do grupo pode 'denunciar' outro pelo não cumprimento de uma tarefa
- Usuários manager são responsáveis por administrar um grupo, adicionando e removendo membros
- Um membro só pode ser removido através de uma votação entre o grupo 
