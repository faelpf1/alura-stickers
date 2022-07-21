# Linguagens Ranking 

Esse projeto é um desafio realizado durante a imersão java_ da Alura, onde foi implementada uma aplicação java com o framework Springboot.

## Tecnologia utilizada
1. **Java 17**
2. **Spring Boot 3.0.0(M4) com as denpedências: Spring Web e Spring Data MongoDB** 
3. **Mongo DB Atlas**

# Observação
Arquivo application.properties com as configurações de acesso ao MongoDB não se encontra nesse repositório e deverá ser adicionado.
Local: src/resources
Conteúdo: spring.data.mongodb.uri=mongodb+srv://<usuario>:<senha>@<host>/<nomeDoBanco>?retryWrites=true&w=majority

## Deafios a serem desenvolvidos

- [ ] Finalizar o CRUD (Create, Read, Update e Delete) para que se possa atualizar e excluir uma linguagem cadastrada;
- [ ] Devolver a listagem ordenada pelo ranking;
- [ ] Criar na sua API um modelo de entidade com nomes diferentes de title e image e criar seu próprio extrator de informações personalizado OU, manter com o nome title e image e traduzir para que seja retornado como título e imagem através do uso de DTO (Data Transfer Object);
- [ ] Retornar o status 201 quando um recurso (linguagem, no nosso caso) for cadastrado através do POST;
- [ ] Desafio supremo: Aplicar modificações parciais no recurso através do método PATCH, por exemplo, modificando o número de votos ou de pessoas que utilizam cada linguagem de programação.