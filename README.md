# innocv-java-exercise

In this project we are going to create a simple CRUD with other importants practices

# Features

1.	Maven
2.	Java 8
3.	Spring Boot 2.2.5
4.	Junit 5
5.	DATA JPA
6.	H2 DATABASE
7.	Lombok


# Test
Se implementan los test para el servicio y para el api con las clases a continuación

```
com.innocv.test.exercise.service.UserServiceImplTest
com.innocv.test.exercise.apicontroller.UserApiControllerImplTest
```

# Http Methods

* POST
```
http://localhost:8080/user

SEND-BODY-JSON
{
    "name": "Andrea",
    "birthDate": "1987-04-27"
}

RESPONSE
{
    "status": "CREATED",
    "message": "User was created",
    "data": {
        "id": 2,
        "name": "Andrea",
        "birthDate": "1987-04-27",
        "createDate": "2020-03-19T21:21:11.618"
    }
}
```

* GET
```
http://localhost:8080/user

RESPONSE
{
    "status": "GET",
    "message": "Users found",
    "data": [
        {
            "id": 1,
            "name": "Robin",
            "birthDate": "1987-04-27",
            "createDate": "2020-03-18T18:45:00.001"
        },
        {
            "id": 2,
            "name": "Andrea",
            "birthDate": "1987-04-27",
            "createDate": "2020-03-19T21:21:11.618"
        }
    ]
}
```

* GET-ID
```
ID=1
http://localhost:8080/user/{ID}

RESPONSE
{
    "status": "GET",
    "message": "User found",
    "data": {
        "id": 1,
        "name": "Robin",
        "birthDate": "1987-04-27",
        "createDate": "2020-03-18T18:45:00.001"
    }
}
```

* GET-Pageable
```
PAGE=0
ROWS=3
http://localhost:8080/user/{PAGE}/{ROWS}

RESPONSE
{
    "status": "GET",
    "message": "Users found by Pageable",
    "data": {
        "content": [
            {
                "id": 1,
                "name": "Robin",
                "birthDate": "1987-04-27",
                "createDate": "2020-03-18T18:45:00.001"
            },
            {
                "id": 2,
                "name": "Amir",
                "birthDate": "1987-04-27",
                "createDate": "2020-03-18T18:45:00.001"
            },
            {
                "id": 3,
                "name": "Argenit",
                "birthDate": "1987-04-27",
                "createDate": "2020-03-18T18:45:00.001"
            }
        ],
        "pageable": {
            "sort": {
                "sorted": false,
                "unsorted": true,
                "empty": true
            },
            "offset": 0,
            "pageSize": 3,
            "pageNumber": 0,
            "unpaged": false,
            "paged": true
        },
        "totalPages": 4,
        "totalElements": 12,
        "last": false,
        "size": 3,
        "number": 0,
        "sort": {
            "sorted": false,
            "unsorted": true,
            "empty": true
        },
        "numberOfElements": 3,
        "first": true,
        "empty": false
    }
}
```

* PUT
```
http://localhost:8080/user

SEND-BODY-JSON
{
    "id": 1,
    "name": "Robin",
    "birthDate": "1988-11-29"
}

RESPONSE
{
    "status": "UPDATED",
    "message": "User was updated",
    "data": {
        "id": 1,
        "name": "Robin",
        "birthDate": "1988-11-29",
        "createDate": "2020-03-19T21:29:02.751"
    }
}
```

* DELETE
```
ID=1
http://localhost:8080/user/{ID}

RESPONSE
{
    "status": "DELETE",
    "message": "User was deleted",
    "data": ""
}
```


