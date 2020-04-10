# Hotel-Java

## Desenvolvimento -> como usá-lo em sua máquina 
#### Para executar o projeto, será necessário instalar os seguintes programas:
- JDK 8 e JDK 7 (Pois o iReport na versão instalada na lib só funciona com JDK 7)
- Netbeans/Eclipse ou qualquer IDE de sua preferência.
- Executar o comando SQL de criação da base de dados e de suas respectivas tarefas, pois como foi meu primeiro projeto, optei por não utilizar ORM que automatiza essa parte do banco de dados.
- Baixar as respectivas libs de conexão com banco de dados e do iReport que podem ser facilmente encontrados [aqui](https://mvnrepository.com)

## Features 
O sistema realiza o controle de hóspedes e de quartos num sistema de hotel, realizando pedidos, reservamentos de quartos por parte dos hóspedes. As recepcionistas podem excluir, editar e consultar os hóspedes, assim como os gerentes fazem o mesmo com ela. Todos esses conceitos de entidades eu explico mais abaixo.

## Entidades 
Os atores ou entidades presentes nesse projeto são bem simples, hierarquicamente de cima pra baixo, temos, respectivametne: Admnistrador, Gerente, Recepcionista e Hóspede, que todos realizam operações de CRUD com os suas entidades, hierarquicamente falando, inferiores. Com excessão do hóspede que não não realiza o CRUD, mas reserva quartos e solicita serviço de quarto juntamente com a recepcionista. 

## Introdução do meu PRIMEIRO projeto - O **porquê** eu o fiz

Eu realizava um curso técnico de informática no meu ensino médio (2018 - 2020) e um dos inúmeros trabalhos, era desenvolver um sistema de gestão de algum estabelecimento, como de um hotel, de um restaurante, petshop, entre outros. O coordenador do curso selecionou os grupos para a realização dos mesmos e o de hotel foi degelado a mim e a minha namorada, pois éramos os aluno que mais se destacavam em programação da turma e era o sistema mais difícil. Ela fez a parte do front-end e eu, a do back-end.

## Linguanges e tecnologias usadas

Como eu estava aprendendo conceitos de POO em Java na época, resolvi aplicar meus conhecimentos com essa oportunidade. Como era meu primeiro contato com a programação de fato - ignorando a lógica de programação - resolvi fazer um CRUD com tecnologias "ultrapassadas".

- JDBC 
- IReport
- Swing

## Como ele funciona 

Foi utilizado como base um [Diagrama ER](https://user-images.githubusercontent.com/49681380/78955702-6c6de780-7ab6-11ea-84c9-1e00e5c8d09f.jpg) que possibilitou uma melhor organização do projeto, além de uma facilitação imensa na hora de progrmar as classes e suas depêndencias. O sistema disponibiliza de: 
- [x] Sistema de usuários com login 
- [x] Controle de autorizações, hierarquia de algumas entidades do programa como: Administrador, Gerente, Recepcionista e Hóspede.
- [x] CRUD de todas as entidades, respeitando a hierarquia de controle de acesso
- [x] Relatório de quartos, hóspedes e repecionistas.

## Conclusão e aprendizados

Como foi meu primeiro contato com programação, eu adquiri **muito** conhecimento, além de macetes que me ajudaram em outros projetos futuro. Aprendi conceitos muito importantes, tais como: 
1. Como funciona uma aplicação Desktop
2. Como funciona uma aplicação Swing
3. Como funciona um Banco de Dados
4. Geração de relatórios 
5. POO e sintaxe Java.





