# Spring Boot - GraphQL - MySQL
[![Spring Boot](https://i.imgur.com/9zObPwT.png)](https://spring.io/projects/spring-boot)
[![GraphQL](https://i.imgur.com/TRGUDTv.png)](https://graphql.org/)
[![MySQL](https://i.imgur.com/0IydTPv.png)](https://www.mysql.com/)<br>
Getting Started with Spring Boot, GraphQL and MySQL

## Data

This demo application communicates with a MySQL database `graphql_db`. The sql file is located in 'resources' folder.

There are three tables: `language`, `user` and `project`. 

Each project has a language and a user that created that project.

_Note that this database and data are just for demonstration purposes._

## Usage

GraphQL endpoint is located at `http://localhost:8080/graphql` and can be changed in `application.properties` file.

To use GraphiQL, locate `http://localhost:8080/graphiql` (notice 'i' in graphiql).

The `.graphqlconfig` file is located in `resources/graphql` folder. The file is used to execute GraphQL from the IntelliJ IDEA.

![IntelliJ IDEA GraphQL](https://i.imgur.com/ze6buJW.png)

#### Queries

`allLanguages` - Returns all languages in the database<br>
`language(id: ID!)` - Returns one language with passed ID<br>
`languageType(languageType: String!)` - Returns languages with passed type (programming, data or markup)<br>
`allProjects: [Project]` - Returns all projects in the database<br>
`project(id: ID!): Project` - Returns one project with passed ID<br>
`userProjects(userId: ID!): [Project]` - Returns all projects created by the user with passed ID<br>
`allUsers: [User]` - Returns all users in the database<br>
`user(id: ID!): User` - Returns one user with passed ID

#### Mutations

`createLanguage(name: String, code: String, color: String, languageType: String): Language!` - Creates a new language<br>
`updateLanguage(id: ID!, name: String, code: String, color: String, languageType: String): Language!` - Updates an existing language<br>
`deleteLanguage(id: ID!): Boolean` - Deletes a language by ID<br>
`createProject(title: String, description: String, language: ID!, user: ID!): Project!` - Creates a new project<br>
`updateProject(id: ID!, title: String, description: String, language: ID, user: ID): Project!` - Updates an existing project<br>
`deleteProject(id: ID!): Boolean` -  Deletes a project by ID<br>
`createUser(username: String, email: String): User!` - Creates a new user<br>
`updateUser(id: ID!, username: String, email: String): User!` - Updates an existing user<br>
`deleteUser(id: ID!): Boolean` -  Deletes a user by ID

#### Demo Usage

Returns name, color and language type for a language with ID 1
```graphql
query {
    language(id: 1) {
        name
        color
        languageType
    }
}
```

Returns id and name of all languages with type 'programming'
```graphql
query {
    languageType(languageType: "programming") {
        id
        name
    }
}
```

Creates a new language and returns id and name
```graphql
mutation {
  createLanguage(name: "Kotlin", code: "kotlin", color: "F18E33", languageType: "PROGRAMMING") {
      id 
      name
  }
}
```

Updates email for user with ID 5 and returns id, username and email
```graphql
mutation {
  updateUser(id: 5, email: "mihajlo.nesic@email.com") {
      id 
      username
      email
  }
}
```

Deletes user with ID 4
```graphql
mutation {
  deleteUser(id: 4)
}
```

Returns all projects created by user with ID 2
```graphql
query {
  userProjects(userId: 2) {
    id
    title
    language {
      name
    }
  }
}
```
