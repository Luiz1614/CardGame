# Projeto Super Trunfo

Este projeto é uma implementação do jogo de cartas Super Trunfo. O jogo é baseado em comparações entre cartas, onde cada carta representa um item com diferentes atributos numéricos, como velocidade, potência, etc. O objetivo do jogo é ganhar todas as cartas do oponente.

## Tecnologias Utilizadas

- Java
- SQL
- Maven

## Estrutura do Projeto

O projeto é estruturado em várias classes que representam diferentes aspectos do jogo:

- `Card`: Esta classe representa uma carta do jogo. Cada carta tem um nome, velocidade, cilindradas, tempo de zero a cem, potência, comprimento, peso, se é uma carta Super Trunfo e o código da coleção a qual pertence.

- `Colecao`: Esta classe representa uma coleção de cartas.

- `CardRepository` e `ColecaoRepository`: Estas classes são responsáveis por realizar operações de banco de dados relacionadas às cartas e coleções, respectivamente.

- `OracleDbConfiguration`: Esta classe é responsável pela configuração da conexão com o banco de dados Oracle.

- `Log4jLogger`: Esta classe é responsável por registrar eventos ou ações que ocorrem durante a execução do programa.

## Como Executar o Projeto

Para executar o projeto, você precisa executar o arquvo SQL que está no projeto para resetar o banco de dados, ter o Java e o Maven instalados em seu sistema. Além disso, você precisa ter um banco de dados Oracle disponível.

1. Clone o repositório do projeto.
2. Navegue até o diretório do projeto e execute o comando `mvn clean install` para construir o projeto.
3. Execute o comando `java -jar target/nome-do-projeto.jar` para iniciar o aplicativo.
