# Languages API

This repository was created for studying purposes in order to follow a one-week imersive classes managed on YouTube from
[Alura's channel on YouTube](https://youtube.com/@alura), which were available only online from March 27th to March 31st
in 2023.

So the purpose was first just follow the classes (which I'll put on a v1.0.0 tag), to then implement my own ideas
(which I'll put in a v2.x.y tag).

The project itself is a simple CRUD API application which interacts with a list of programming languages, just to show
how to do it in Java using Spring Boot and MongoDB. It can be also in conjunction with [Alura Sticker Generator](https://github.com/JeanBarbosa27/imersao-java-marco-2023-alura-sticker-generator)
which is another project created during the same one-week imersive classes, that creates stickers by a given image, so
this API can be used to serve the images to be used in the stickers with the languages logos, its name and raking,
for example.

## Project dependencies
 
- Java
- Maven
- Spring Boot
- MongoDB

## How to run locally

### Environment variables

First of all, you need to create a system environment variable called `SPRING_DATA_MONGODB_URI`, which must hold the
whole Mongo DB URI connection string, to be able to connect the mongo DB when running the application.

---

🚧🚧 

**Document under construction**

- [ ] Add following sections:
  - [x] description
  - [x] project dependencies
  - [ ] how to run locally
  - [ ] how to create a new build package <!-- ./mvnw clean package or create a configuration -->
  - [ ] road map

🚧🚧
