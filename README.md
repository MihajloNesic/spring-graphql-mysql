# Spring Boot - GraphQL - MySQL
[![Spring Boot](https://i.imgur.com/9zObPwT.png)](https://spring.io/projects/spring-boot)
[![GraphQL](https://i.imgur.com/TRGUDTv.png)](https://graphql.org/)
[![MySQL](https://i.imgur.com/0IydTPv.png)](https://www.mysql.com/)<br>
Getting Started with Spring Boot, GraphQL and MySQL

## Data

This demo application communicates with a MySQL database `languages`. The sql file is located in 'resources' folder.

There are two tables: `language` and `language_type`.

_Note that this database and data are just for demonstration porupuses._

GraphQL schema is defined in `schema.graphql` in 'resources' folder.

## Usage

GraphQL endpoint is located at `http://localhost:8080/graphql`

To use GraphiQl, locate `http://localhost:8080/graphiql` (notice 'i' in graphiql).

#### Queries

`allLanguages` - Returns all languages in the database<br>
`language(id: Stirng)` - Returns one language with passed ID<br>
`languageType(languageType: String)` - Returns languages with passed type (programming, data or markup)

#### Demo Usage

Returns name, color and language type for a langauge with ID 1
```
language(id: 1) {
    name
    color
    languageType
}
```

Returns id and name of all languages with type 'programming'
```
languageType(languageType: "programming") {
    id
    name
}
```

Returns id, name, code and language type of all languages
```
allLanguages {
    id
    name
    code
    languageType
}
```

