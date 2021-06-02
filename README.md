# Bookshelf
A simple Spring app for organizing your personal library.


## What
Bookshelf helps you keep track of which books you have read, are reading, or planning to read.


## How 
### Requirements
This app requires Maven, JDK 1.8, and a local MongoDB server.

### Running the API
Clone this repo, start mongodb, and run `./mvnw spring-boot:run`.

### Endpoints

| Method | PATH                                           | Description                                |
| ------ | ---------------------------------------------- | ------------------------------------------ |
| GET    | /api/books                                     | Retrieve all books                         |
| POST   | /api/books                                     | Create a book                              |
| PUT    | /api/books/{id}                                | Update a book                              |
| DELETE | /api/books/{id}                                | Delete a book                              |
| GET    | /api/books/search/findByTitle?title={title}    | Retrieve all books matching a given title  |
| GET    | /api/books/search/findByStatus?status={status} | Retrieve all books matching a given status |

All responses follow the hal+json format of HATEOAS.

### The Book Model

| Property      | Type         | Null | Description                                        |
| ------------- | ------------ | ---- | -------------------------------------------------- |
| id            | String       | No   | unique identifier for the book (auto-generated)    |
| title         | String       | No   | the title of the book                              |
| authors       | List<String> | No   | the author(s) of the book                          |
| status        | String       | No   | Must be one of: 'backlog', 'reading', 'completed'  |
| coverImage    | String       | Yes  | URL of an image of the book cover (auto-generated) |

The service uses the [Open Library API](https://openlibrary.org/developers/api) in fetching a cover image that matches the book info.


## Why
This is for all the folks out there who, like me, have a looooong backlog of unread books that they want to read.


## Where
[Here](https://bookshelf-zandrexrc.netlify.app/) is a simple frontend demo.


## When
I made the initial version of this Spring app in the spring of 2018, as a personal project in Java and web development.   
Three years later in 2021, I decided to update and rebuild this project because I realized that I didn't have any Java projects uploaded in my GitHub profile :-D


## Who 
This project is created by [yours truly](https://zandrexrc.me). 
Book covers courtesy of [Open Library](https://openlibrary.org/developers/api).